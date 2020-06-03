import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main {

	public static void main(String[] args) {
		

		 @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Aspectexample.xml");
			
			Cal cal = (Cal) context.getBean("cal");
			cal.add(1016789, 1675);
			try {
				cal.div(1764874588, 244937);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			cal.sub(1016789, 1675);
			cal.mod(746582019,2657);


	}

}
