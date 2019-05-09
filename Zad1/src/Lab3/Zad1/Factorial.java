package Lab3.Zad1;
public class Factorial{
    private int wynik = 1;


    public int factorial(int x){
        if(x < 0) throw new IllegalArgumentException("X nie może być mniejszy od 0");
        for (int i = x; i > 0; i--) {
            wynik *= i;
        }
        return wynik;
    }

    public int factorialWithMyException(int x) throws MyException{
        if(x < 0) throw new MyException("x nie może być mniejszy od 0");
        for (int i = x; i > 0; i--) {
            wynik *= i;
        }
        return wynik;
    }
}
