package io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions;

public class ExceptionOne extends Exception {

    public ExceptionOne() {
        super();
    }

    @Override
    public String toString() {
        return "ExceptionOne";
    }

    @Override
    public String getMessage() {
        return "I am " + toString();
    }
}
