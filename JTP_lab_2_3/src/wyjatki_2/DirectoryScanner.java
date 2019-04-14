package wyjatki_2;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DirectoryScanner {
    public static void scan(String filePath, String fileName) {
        try {
            if(fileFound(filePath, fileName)) {
                File file = new File(filePath + "/" + fileName);
                Log.log(file.getAbsolutePath());
                removeFile(file);
            }
        }catch(Exception e) {
            System.out.println(e);
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch(Exception ex) {
                System.out.println(ex);
            }

            scan(filePath, fileName);

        }
    }

    public static boolean fileFound(String filePath, String fileName) throws MyException {
        File file = new File(filePath);
        if(!file.isDirectory()) {
            System.out.println("The path is not a directory.");
            return false;
        }
        file = new File(filePath+ File.separator + fileName);
        if(file.exists()) {
            return true;
        }
        else {
            throw new MyException("File not found!");
        }
    }

    public static void removeFile(File file) {
        if(file.delete()){
            System.out.println("File " + file.getName() + " deleted from the directory");
        }else System.out.println("File " + file.getName() + " doesn't exist in this directory");
    }
}
