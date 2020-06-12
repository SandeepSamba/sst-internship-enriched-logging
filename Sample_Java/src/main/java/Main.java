import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//selecting a log level	 
		 int choose_log_func = 2;
		 ApplicationContext context = null;
		 
		 if(choose_log_func == 0) {
			 context = new ClassPathXmlApplicationContext("Aspectexample.xml");
		 }
		 else if(choose_log_func == 1) {
			 context = new ClassPathXmlApplicationContext("debug.xml");

		 }
		 else if(choose_log_func == 2) {
			 context = new ClassPathXmlApplicationContext("error.xml");

		 }
		 else if(choose_log_func == 3) {
			 context = new ClassPathXmlApplicationContext("fatal.xml");

		 }
		 else {
			 context = new ClassPathXmlApplicationContext("trace.xml");

		 }
		//Retrieving the required bean
			Cal cal = (Cal) context.getBean("cal");
			cal.add(1016789, 1675);
			try {
				cal.div(1764874588,128974);
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			cal.sub(1016789, 1675);
			cal.mod(746582019,2657);
			
			
/*Test runner for junit test cases
 *Running test class with runClasses method of junit core class
 *getFailures() method to get failures
 *wasSuccesful() method to get success results			
 */ 
			
			Result result = JUnitCore.runClasses(testclass.class);
				
		    for (Failure failure : result.getFailures()) {
		         System.out.println(failure.toString());
		      }
				
		     System.out.println(result.wasSuccessful());


	}

}
