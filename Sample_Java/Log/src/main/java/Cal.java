


public class Cal {
	@Timed
	public void add(int a, int b) {
	
		System.out.println("Add result: " + (a+b));
		
		
	}
	
	@Timed
	public void div(int a, int b) throws Exception {
		if(b!=0) {
			
			System.out.println("Division result: " + (a/b));
		}
		else {
			throw new ArithmeticException("Not divisble by 0");
		}
		
	}
	@Timed
	public void sub(int a, int b) {
	
		System.out.println("Subtraction result: " + (a-b));
		
		
	}
	@Timed
	public void mod(int a, int b) {
	
		System.out.println("Mod result: " + (a%b));
		
		
	}


}
