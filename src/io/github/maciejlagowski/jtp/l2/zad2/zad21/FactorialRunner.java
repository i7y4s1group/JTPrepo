package io.github.maciejlagowski.jtp.l2.zad2.zad21;

import io.github.maciejlagowski.jtp.l2.zad2.zad21.Exceptions.MyException;

public class FactorialRunner {
    public static void main(String[] args) {

        int xTab[] = {-3, -1, 0, 1, 2, 4, 5};

        System.out.println("factorial method:");
        for (int x : xTab) {
            try {
                System.out.println(x + "! = " + Factorial.factorial(x));
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("factorialWithMyException method:");
        for (int x : xTab) {
            try {
                System.out.println(x + "! = " + Factorial.factorialWithMyException(x));
            } catch (MyException ex) {
                ex.printStackTrace();
                System.err.println(ex.getMessage());
            }
        }
    }
}
