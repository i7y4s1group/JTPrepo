import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int[] numbersToCheck = {-3, -1, 0, 1, 2, 4, 5};

        for (int i = 0; i < numbersToCheck.length; i++) {
            try {
                System.out.println(factorial.factorial(numbersToCheck[i]));
            }catch (IllegalArgumentException exception){
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }

        for (int i = 0; i < numbersToCheck.length; i++) {
            try {
                System.out.println(factorial.factorialWithMyException(numbersToCheck[i]));
            } catch (MyException myException) {
                System.err.println(myException.getMessage());
                myException.printStackTrace();
            }
        }

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
        Random ran = new Random();
        int randInt = ran.nextInt(2 + 1);

        if(randInt == 1){
            throw new MyException1("THE EXCEPTION NUMBER 1 HAS BEEN THROWN");
        }
        else if(randInt == 2){
            throw new MyException2("THE EXCEPTION NUMBER 2 HAS BEEN THROWN");
        }
        else{
            throw  new MyException3("THE EXCEPTION NUMBER 3 HAS BEEN THROWN");
        }
    }
}