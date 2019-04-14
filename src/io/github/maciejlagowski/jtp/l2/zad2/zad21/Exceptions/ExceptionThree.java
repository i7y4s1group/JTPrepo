package io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions;

public class ExceptionThree extends Exception {

    public ExceptionThree() {
        super();
    }

    @Override
    public String toString() {
        return "ExceptionThree";
    }

    @Override
    public String getMessage() {
        return "I am " + toString();
    }
}
