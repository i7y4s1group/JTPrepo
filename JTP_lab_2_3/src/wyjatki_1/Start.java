package wyjatki_1;

public class Start {
    public static void main(String[] args) {
        for(int i = -3; i < 6; i++) {
            try {
                System.out.println("factorial: " + Factorial.factorial(i));
            }
            catch(IllegalArgumentException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

        for(int i = -3; i < 6; i++) {
            try {
                System.out.println("factorialWithMyException: " + Factorial.factorialWithMyException(i));
            }
            catch(MyException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

        for(int i = 0; i < 5; i++) {
            try{
                Factorial.randomException();
            }
            catch(Exception1 | Exception2 | Exception3 e) {
                System.out.println(e);
            }
        }

    }
}
