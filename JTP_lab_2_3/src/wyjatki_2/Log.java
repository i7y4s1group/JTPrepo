package wyjatki_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    public static void log(String msg) {
        File file = new File(System.getProperty("user.home") + "/Desktop/log.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(msg + System.getProperty("line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Log: " + msg);
    }
}
