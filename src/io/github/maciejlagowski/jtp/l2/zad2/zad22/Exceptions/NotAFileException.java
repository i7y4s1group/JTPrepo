package io.github.maciejlagowski.jtp.l2.zad2.zad22.Exceptions;

public class NotAFileException extends Exception {
    public NotAFileException() {
        super();
    }

    @Override
    public String toString() {
        return "CanNotReadException";
    }

    @Override
    public String getMessage() {
        return toString() + ": The file found is not a file";
    }
}
