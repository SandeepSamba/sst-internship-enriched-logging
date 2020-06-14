package main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		 ApplicationContext context =  new ClassPathXmlApplicationContext("Aspectexample.xml");
		 

		//Retrieving the required bean
			Cal cal = (Cal) context.getBean("cal");
		
			cal.add(1016789, 1675);
			try {
				cal.div(1764874588,0);
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			cal.sub(1016789, 1675);
			cal.mod(746582019,2657);
			
	}

}
