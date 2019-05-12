package Blok2.Zadanie1;

//soutem wyisac i print stack trace
//2 to wlasny wyjatekvjak zostanie zlapany -> przetwarzanie uspac na 1 minute
//wykorzystac klase File, musi sprawdzac czy sciezka nie jest plikiem czy mamy uprawnienia do czytania i usuwania
//jesli uprawnienia nie ma zwracamy wyjatek z exceptions file
//oddzielna klasa i metoda do logowania FileWriter

import Blok2.Zadanie1.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int[] numbersToCheck = {-3, -1, 0, 1, 2, 4, 5};

        //------------------------------------POINT A/C------------------------------------
        for (int i = 0; i < numbersToCheck.length; i++) {
            try {
                System.out.println(factorial.factorial(numbersToCheck[i]));
            }catch (IllegalArgumentException exception){
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }

        //------------------------------------POINT B/C------------------------------------
        for (int i = 0; i < numbersToCheck.length; i++) {
            try {
                System.out.println(factorial.factorialWithMyException(numbersToCheck[i]));
            } catch (MyException myException) {
                System.err.println(myException.getMessage());
                myException.printStackTrace();
            }
        }

        //------------------------------------POINT E------------------------------------
        try{
            randException();
        } catch (MyException1 exceptionFirst){
            System.err.println(exceptionFirst.getMessage());
            exceptionFirst.printStackTrace();
        } catch (MyException2 exceptionSecond){
            System.err.println(exceptionSecond.getMessage());
            exceptionSecond.printStackTrace();
        } catch (MyException3 exceptionThird){
            System.err.println(exceptionThird.getMessage());
            exceptionThird.printStackTrace();
        }
    }

    public static void randException() throws MyException1, MyException2, MyException3 {
        Random draw = new Random();
        int numberOfException = draw.nextInt(2 + 1);

        if(numberOfException == 1){
            throw new MyException1("THE EXCEPTION NUMBER 1 HAS BEEN THROWN");
        }
        else if(numberOfException == 2){
            throw new MyException2("THE EXCEPTION NUMBER 2 HAS BEEN THROWN");
        }
        else{
            throw  new MyException3("THE EXCEPTION NUMBER 3 HAS BEEN THROWN");
        }
    }
}
