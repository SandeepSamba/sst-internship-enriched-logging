import java.util.ArrayList;

import org.apache.log4j.Logger;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(Main.class);
		Cal cal = new Cal();
		int result1 = cal.add(10, 10);	
		System.out.println(result1);
		
		try {
			int result2 = cal.div(1, 2);
			System.out.println(result2);
		}
		catch(Exception e) {
			System.out.println(e);
		}

	   
	
		String sec = "" + System.currentTimeMillis() / 1000;
		ArrayList<String> Attributes = new ArrayList<String>();
		ArrayList<String> Attributetype = new ArrayList<String>();
        LogMessage logmessage = new LogMessage(sec,"My Test Class Name", "My Test Method Name", "My Test Calling Class Name",Attributes,Attributetype) ;
       System.out.println(logmessage.ClassName);
      String mes=logmessage.timestamp();
       System.out.println(mes);
        //LogMessageDecorator logMessageDecorator = new LogMessageDecorator(logmessage);
        //System.out.printf(logMessageDecorator.classname());
        Jsonconvert jsonconv = new Jsonconvert();
        String log = jsonconv.convert(logmessage.timestamp(),logmessage.classname(),
                logmessage.methodname(),logmessage.callingclassname(),
                logmessage.attributes(),logmessage.attributetypes());
        logger.info(log);
        



	}

}
