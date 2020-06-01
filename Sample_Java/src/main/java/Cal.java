


public class Cal {
	public int add(int a, int b) {
		return a+b;
	}
	
	public int div(int a, int b) throws Exception {
		if(b!=0) {
			return a/b;
		}
		else {
			throw new ArithmeticException("Not divisble by 0");
		}
		
	}

}
