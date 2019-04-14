import java.util.*;

public class Main {
    public static void main(String[] args) {
        /****************** First Part - Collections ******************/

        /*ClientsCollection clientsCollection = new ClientsCollection();

        clientsCollection.addName("Jan");
        clientsCollection.addName("Adam");
        clientsCollection.addName("Bogdan");
        clientsCollection.addName("Zenon");
        clientsCollection.addName("Dawid");
        clientsCollection.addName("Janusz");
        clientsCollection.addName("Zbigniew");
        clientsCollection.addName("Karol");
        clientsCollection.addName("Andrzej");
        clientsCollection.addName("Mateusz");

        clientsCollection.addClient("Jan", "Kowalski");
        clientsCollection.addClient("Adam", "Nowak");
        clientsCollection.addClient("Polak", "Robak");

        clientsCollection.randomClient2();
        clientsCollection.randomClient2();
        clientsCollection.randomClient2();*/

        /****************** Second Part - Exceptions ******************/

        Factorial fac = new Factorial();
        Integer[] numbers = new Integer[] {-3, -1, 0, 2, 4, 5};

        for(Integer i: numbers)
        {
            int x  = i.intValue();
            System.out.println("x = " + x);

            int random = (int)(Math.random() * (double)3);

            switch(random)
            {
                case 0:
                    try
                    {
                        System.out.println( x + "! = " + fac.factorialWithMyException(x));
                    }
                    catch(MyException exception)
                    {
                        System.out.println(exception);
                        exception.printStackTrace();
                    }
                    break;
                case 1:
                    try
                    {
                        System.out.println( x + "! = " + fac.factorialWithMyExtraException(x));
                    }
                    catch(MyExtraException exception)
                    {
                        System.out.println(exception);
                        exception.printStackTrace();
                    }
                    break;
                case 2:
                    try
                    {
                        System.out.println( x + "! = " + fac.factorial(x));
                    }
                    catch(IllegalArgumentException exception)
                    {
                        System.out.println(exception);
                        exception.printStackTrace();
                    }
                    break;
            }


        }
    }
}
