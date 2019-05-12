package Blok2.Zadanie1;

public class Factorial {
    public int factorial(int x){
        if(x < 0) {
            throw new IllegalArgumentException("THE ARGUMENT HAS A VALUE LESS THAN 0");
        }
        if(x == 0) {
            return 1;
        }
        return x * factorial(x - 1);
    }

    public int factorialWithMyException(int x) throws MyException {
        if (x < 0) {
            throw new MyException("THE ARGUMENT HAS A VALUE LESS THAN 0");
        }
        if (x == 0) {
            return 1;
        }
        return x * factorialWithMyException(x - 1);
    }
}
