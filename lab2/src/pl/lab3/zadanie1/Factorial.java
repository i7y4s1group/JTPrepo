package pl.lab3.zadanie1;

public class Factorial {
    private int factorial;

    Factorial(int x) {
        //if(x<0) throw

        int factorial = 1;
        for (int i = x; i > 0; i--) {
            factorial *= i;
        }
        this.factorial = factorial;
    }

    public int getFactorial() {
        return factorial;
    }
}
