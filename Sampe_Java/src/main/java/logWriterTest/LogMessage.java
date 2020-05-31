package logWriterTest;

import java.util.ArrayList;

public class LogMessage implements Logger {
	String TimeStamp = "";
	String ClassName = "";
	String MethodName = "";
	String CallingClassName="";
	ArrayList<String> Attributes = new ArrayList<String>();
	ArrayList<String> Attributetype = new ArrayList<String>();
	
	public  LogMessage() {
		
	}

	public LogMessage(String timestamp,String classname,String methodname,String callingclassname,ArrayList<String> attributes,ArrayList<String> attributetype) {
		this.TimeStamp=timestamp;
		this.ClassName=classname;
		this.MethodName=methodname;
		this.CallingClassName=callingclassname;
		this.Attributes=attributes;
		this.Attributetype=attributetype;
		
	}
	
	
	
}
