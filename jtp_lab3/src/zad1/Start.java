package zad1;

import java.util.Random;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] tab = {-3, -1, 0, 1, 2, 4, 5};
		//a(tab);
		//b(tab);
		e();
		
	}
	
	
	public static void a(int [] tab) {
		Factorial fact = new Factorial();
		
		for(int i = 0; i < 5 ; i++) {
			fact.factorial(tab[i]);
			System.out.println(tab[i] + "! = " + fact);
		}
		
	/*	
		fact.factorial(x);
		System.out.println(x + "! = " + fact);
		*/
		
		
		
		
	}
	
	public static void b(int [] tab) {
		Factorial fact = new Factorial();
		
		try {
			for(int i = 0; i < 5 ; i++) {
				fact.factorialWithMyException(tab[i]);
				System.out.println(tab[i] + "! = " + fact);
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	
	public static void e() {
		try {
			ef(Factorial.random());
			
		}catch (FirstException e) {			
			e.printStackTrace();
			System.out.print("First");
		}catch (SecondException e) {
			e.printStackTrace();
			System.out.print("Second");
		}catch (ThirdException e) {
			e.printStackTrace();
			System.out.print("Third");
		}finally {
			System.out.println(" Exception");
		}
		
	}
	
	
	
	
	public static void ef(int x) throws FirstException,  SecondException, ThirdException{
		
		if (x == 1) {
			throw new FirstException("Hello it's the first Exception");
		}
		else if (x == 2) {
			throw new SecondException("I am the second Exception");
		}
		else {
			throw new ThirdException("Why am I the last one?");
		}
	}
	
	
	
}
