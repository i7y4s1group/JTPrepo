package zad1;

import java.util.Random;

public class Factorial {
	
		int equals;
	
	
	public void factorial(int x) {
		
		if (x < 0) {
			throw new IllegalArgumentException("The number you want factorial of need to be >= 0. You gave me: " + x);
		}
		
		equals = 1;
		
		for (int i = 1; i <= x; i++) {
			equals *= i;			
		}		
		
	}
	
	public void factorialWithMyException(int x) throws MyException {
		if (x < 0) {
			throw new MyException("The number you want factorial of need to be >= 0. You gave me: " + x);
		}
		
		equals = 1;
		
		for (int i = 1; i <= x; i++) {
			equals *= i;			
		}				
	}

	@Override
	public String toString() {
		
		return " =" + equals;
	}
	
	public static int random() throws FirstException,  SecondException, ThirdException{
		Random rand = new Random();
		return (1 + rand.nextInt(3));
	}
	
}
