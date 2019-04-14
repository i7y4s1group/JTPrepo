package io.github.maciejlagowski.jtp.l2.zad2.zad22;

import io.github.maciejlagowski.jtp.l2.zad2.zad22.Exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class FileSearcher extends Thread {
    private String directoryLocation;
    private String fileName;

    FileSearcher(String directoryLocation, String fileName) {
        this.directoryLocation = directoryLocation;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                searchFile();
            } catch (CanNotReadException canNotReadException) {
                System.err.println(canNotReadException.getMessage());
            } catch (CanNotWriteException canNotWriteException) {
                System.err.println(canNotWriteException.getMessage());
            } catch (MyFileNotFoundException myFileNotFoundException) {
                System.err.println(myFileNotFoundException.getMessage());
                mySleep();
            } catch (NotAFileException notAFileException) {
                System.err.println(notAFileException.getMessage());
            }
        }
    }

    private void searchFile() throws MyFileNotFoundException, CanNotReadException, CanNotWriteException, NotAFileException {
        File file = new File(directoryLocation);
        File[] listOfFiles = file.listFiles();

        if (file.isDirectory() && listOfFiles != null) {
            System.out.println("Searching file " + fileName + " in location " + directoryLocation + " ...");

            for (File f : listOfFiles) {
                System.out.println(f.getName());
                if (fileName.equals(f.getName()) && f.isFile()) {

                    if (f.canRead() && f.canWrite()) {
                        System.out.println("#################");
                        System.out.println("found: " + f.getName());
                        System.out.println("#################");
                        makeLogAndDelete(f);
                        return;
                    } else if (!f.canRead()) {
                        throw new CanNotReadException();
                    } else if (!f.canWrite()) {
                        throw new CanNotWriteException();
                    }

                } else if (fileName.equals(f.getName()) && !f.isFile()) {
                    throw new NotAFileException();
                }
            }
        } else {
            if (file.isFile() && file.getName().equals(fileName)) {
                System.out.println("#################");
                System.out.println("found: " + file.getName());
                System.out.println("#################");
                makeLogAndDelete(file);
                return;
            }
        }
        throw new MyFileNotFoundException();
    }

    private void makeLogAndDelete(File file) {
        try {
            FileWriter fileWriter = new FileWriter(new File("log.txt"));
            fileWriter.write(file.getAbsolutePath());
            fileWriter.close();
            file.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void mySleep() {
        try {
            sleep(60000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
