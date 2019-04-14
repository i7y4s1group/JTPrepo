package io.github.maciejlagowski.jtp.l2.zad2.zad22.Exceptions;

import java.io.FileNotFoundException;

public class MyFileNotFoundException extends FileNotFoundException {

    public MyFileNotFoundException() {
        super();
    }

    @Override
    public String toString() {
        return "MyFileNotFoundException";
    }

    @Override
    public String getMessage() {
        return toString() + ": File not found";
    }

}
