package io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions;

public class MyException extends Exception {

    public MyException() {
        super();
    }

    @Override
    public String getMessage() {
        return toString() + ": x can't be a negative value";
    }

    @Override
    public String toString() {
        return "MyException";
    }

}
