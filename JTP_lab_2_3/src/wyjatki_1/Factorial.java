package wyjatki_1;

import java.util.Random;

public class Factorial {
    public static int factorial(int x) {
        if(x < 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        else {
            int tmp = 1;
            for (int i = 1; i <= x; i++) {
                tmp *= i;
            }
            return tmp;
        }
    }

    public static int factorialWithMyException(int x) throws MyException {
        if(x < 0) {
            throw new MyException("Invalid argument");
        }
        else {
            int tmp = 1;
            for (int i = 1; i <= x; i++) {
                tmp *= i;
            }
            return tmp;
        }
    }

    public static void randomException() throws Exception1, Exception2, Exception3 {
        Random rand = new Random();
        switch(rand.nextInt(3)) {
            case 0:
                throw new Exception1("Exception1");
            case 1:
                throw new Exception2("Exception2");
            case 2:
                throw new Exception3("Exception3");
        }
    }
}
