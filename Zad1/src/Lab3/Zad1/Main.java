package Lab3.Zad1;

import java.util.Random;

public class Main {

    //file access denied
    //filewriter
    //log4j
    public static void main(String[] args) throws MyException2, MyException1, MyException3 {
        Factorial silnia = new Factorial();
        Factorial silnia1 = new Factorial();
        int[] test = {-3, -1, 0, 1, 2, 4, 5};
        for (int i = 0; i < 7; i++) {

            try {
                System.out.println(silnia.factorialWithMyException(test[i]));
            } catch (MyException e) {
                System.err.println(e.getWiadomosc());
                e.printStackTrace();
                ;
            }

        }

        for (int i = 0; i < 7; i++) {

            try {
                System.out.println(silnia1.factorial(test[i]));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }

        try {
            losujWyjatek();
        } catch (MyException1 e1) {
            System.err.println(e1.getWiadomosc());
            e1.printStackTrace();
        } catch (MyException2 e2) {
            System.err.println(e2.getWiadomosc());
            e2.printStackTrace();
        } catch (MyException3 e3) {
            System.err.println(e3.getWiadomosc());
            e3.printStackTrace();
        }
    }


        public static void losujWyjatek () throws MyException1, MyException2, MyException3 {
            Random rand = new Random();
            int los = rand.nextInt(3);

            if (los == 0) {
                throw new MyException1("MyException1");
            }
            if (los == 1) {
                throw new MyException2("MyException2");
            }
            if (los == 2) {
                throw new MyException3("MyException3");
            }
        }




}

