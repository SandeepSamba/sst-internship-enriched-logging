import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main {

	public static void main(String[] args) {
		

		 @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Aspectexample.xml");
			
			Cal cal = (Cal) context.getBean("cal");
			cal.add(1, 2);
			try {
				cal.div(2, 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
