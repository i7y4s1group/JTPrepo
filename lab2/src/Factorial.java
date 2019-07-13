import java.util.*;

class MyException extends Exception {
    public MyException(String errorMessage) {
        super(errorMessage);
    }
}

class MyExtraException extends Exception {
    public MyExtraException(String errorMessage) {
        super(errorMessage);
    }
}

public class Factorial {
    public int factorialWithMyExtraException(int x) throws MyExtraException
    {
        int result = 1;

        if(x < 0)
        {
            throw new MyExtraException("Argument musi być większy od 0!");
        }

        for(int i = 1; i <= x; i++)
        {
            result *= i;
        }

        return result;
    }
    public int factorialWithMyException(int x) throws MyException
    {
        int result = 1;

        if(x < 0)
        {
            throw new MyException("Argument musi być większy od 0!");
        }

        for(int i = 1; i <= x; i++)
        {
            result *= i;
        }

        return result;
    }

    public int factorial(int x)
    {
        int result = 1;

        if(x < 0)
        {
            throw new IllegalArgumentException("Argument musi być większy od 0!");
        }

        for(int i = 1; i <= x; i++)
        {
            result *= i;
        }

        return result;
    }
}
