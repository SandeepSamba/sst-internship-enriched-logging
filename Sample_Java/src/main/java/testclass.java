import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/* This class tests the concrete class LogMessage with junit testing framework.LogMessage class 
 * is instantiated with various objects and is tested with several test cases.
  */

public class testclass {
	
	 ArrayList<Object> attributes = new ArrayList<Object>();
	 ArrayList<Object> attributetype = new ArrayList<Object>();
	 
	 
   LogMessage logmessage = new LogMessage("72363","Cal","add","main",attributes,attributetype,null);

   @Test
   public void testPrintMessage() {
	  System.out.println("Test case 1 running");
      assertEquals("72363",logmessage.timestamp());
      assertEquals("Cal",logmessage.classname());
      assertEquals("add",logmessage.methodname());
      assertEquals("main",logmessage.callingclassname());
      
   }
   LogMessage logmessage1 = new LogMessage("72363","Cal","sub","main",attributes,attributetype,null);
   @Test
   public void testPrintMessage1() {
	   System.out.println("Test case 2 running");
	      assertEquals("72363",logmessage1.timestamp());
	      assertEquals("Cal",logmessage1.classname());
	      assertEquals("sub",logmessage1.methodname());
	      assertEquals("main",logmessage1.callingclassname());
	      
	   }
   LogMessage logmessage2 = new LogMessage("72363","Cal","add","main",attributes,attributetype,null);
   @Test
   public void testPrintMessage2() {
	   System.out.println("Test case 3 running");
	      assertEquals("72363",logmessage2.timestamp());
	      assertEquals("Cal",logmessage2.classname());
	      assertEquals("add",logmessage2.methodname());
	      assertEquals("main",logmessage2.callingclassname());
	      
	   }

}