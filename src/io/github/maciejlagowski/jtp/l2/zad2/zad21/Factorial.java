package io.github.maciejlagowski.jtp.l2.zad2.zad21;

import io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions.MyException;

class Factorial {

    static int factorial(int x) {
        if (x >= 0) {
            int fac = 1;
            for (int i = 1; i <= x; i++) {
                fac *= i;
            }
            return fac;
        } else {
            throw new RuntimeException();
        }
    }

    static int factorialWithMyException(int x) throws MyException {
        if (x < 0) {
            throw new MyException();
        } else {
            int fac = 1;
            for (int i = 1; i <= x; i++) {
                fac *= i;
            }
            return fac;
        }
    }
}
