package io.github.maciejlagowski.jtp.l2.zad2.zad21;

import io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions.ExceptionOne;
import io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions.ExceptionThree;
import io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions.ExceptionTwo;

import java.util.Random;

public class ExceptionsRunner {
    public static void main(String[] args) {
        try {
            runExceptionsRandom();
        } catch(ExceptionOne exceptionOne) {
            System.err.println(exceptionOne.getMessage());
        } catch(ExceptionTwo exceptionTwo) {
            System.err.println(exceptionTwo.getMessage());
        } catch (ExceptionThree exceptionThree) {
            System.err.println(exceptionThree.getMessage());
        }
    }

    private static void runExceptionsRandom() throws ExceptionOne, ExceptionTwo, ExceptionThree {
        Random random = new Random();
        switch(random.nextInt(3)) {
            case 0:
                throw new ExceptionOne();
            case 1:
                throw new ExceptionTwo();
            case 2:
                throw new ExceptionThree();
        }
    }
}
