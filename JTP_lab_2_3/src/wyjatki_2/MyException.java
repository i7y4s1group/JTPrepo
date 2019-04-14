package wyjatki_2;

import java.io.FileNotFoundException;

public class MyException extends FileNotFoundException {
    public MyException(String msg) {
        super(msg);
    }
}
