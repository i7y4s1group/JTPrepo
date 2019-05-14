package io.github.maciejlagowski.jtp.l5.zad1;

public class FileSupport {
    private FileSupportInterface fileSupport;

    public void set(FileSupportInterface fileSupport) {
        this.fileSupport = fileSupport;
    }

    public void processFile() {
        fileSupport.processFile();
    }

    public void moveFile(String locationToMove) {
        fileSupport.moveFile(locationToMove);
    }
}
