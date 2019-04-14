package io.github.maciejlagowski.jtp.l2.zad2.zad22.Exceptions;

public class CanNotReadException extends Exception {
    public CanNotReadException() {
        super();
    }

    @Override
    public String toString() {
        return "CanNotReadException";
    }

    @Override
    public String getMessage() {
        return toString() + ": User doesn't have permission to read file";
    }
}
