package Blok2.Zadanie2;

public class Main {
    public static void main(String[] args) {
        int noFiles = 0;
        DirectoryScanner directoryScanner = new DirectoryScanner(
                "C:\\Users\\Mateusz\\Desktop\\Pliki",
                "Log.txt");

        while (noFiles != 1){
            try {
                directoryScanner.eraseFilesFromDirectory();
                noFiles--;
            } catch (MyFileException e) {
                System.err.println(e.getMessage());
                directoryScanner.showErrors();
                sleep(60000);
                noFiles++;
            }
        }

        directoryScanner.closeLogFile();
    }

    private static void sleep(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
