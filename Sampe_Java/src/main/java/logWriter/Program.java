
package logWriter;
//import logWriterTest.LogMessage;
//import logWriterTest.Logger;
import logWriterTest.*;

public class Program {
	//private static Logger logmessage=
	@SuppressWarnings("unused")
	private static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
            if (args == null)
            {
                throw new Exception("args");
            }

            LogSample();
            TestImplementation();
        }
	static void TestImplementation()
    {	
		String sec = "" + System.currentTimeMillis() / 1000;
        LogMessage logmessage = new LogMessage("sec","My Test Class Name", "My Test Method Name", "My Test Calling Class Name",null,null);
        LogMessageDecorator nLogMessageDecorator = new LogMessageDecorator(logmessage);
        System.out.println("Class Name : {0}", nLogMessageDecorator.ClassName);
    }

    static void LogSample()
    {

        Mysameplelogger.Info("ss");


    }
		
	

}
