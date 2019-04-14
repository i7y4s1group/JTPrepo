package io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions;

public class ExceptionTwo extends Exception {

    public ExceptionTwo() {
        super();
    }

    @Override
    public String toString() {
        return "ExceptionTwo";
    }

    @Override
    public String getMessage() {
        return "I am " + toString();
    }
}
