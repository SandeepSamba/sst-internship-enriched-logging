package main;
//calculator application

import logwriter.LogEnum;
import logwriter.Logged;

public class Cal {
	@Logged()
	public void add(int a, int b) {
	
		System.out.println("Add result: " + (a+b));
		
		
	}
	
	@Logged(level=LogEnum.DEBUG)
	public void div(int a, int b) throws Exception {
		if(b!=0) {
			
			System.out.println("Division result: " + (a/b));
		}
		else {
			throw new ArithmeticException("Not divisble by 0");
		}
		
	}
	@Logged()
	public void sub(int a, int b) {
	
		System.out.println("Subtraction result: " + (a-b));
		
		
	}
	@Logged()
	public void mod(int a, int b) {
	
		System.out.println("Mod result: " + (a%b));
		
		
	}


}
