package logWriterTest;

import java.util.ArrayList;

public interface Logger {
	public String TimeStamp = "";
	public String ClassName = "";
	public String MethodName = "";
	public String CallingClassName="";
	public ArrayList<String> Attributes = new ArrayList<String>();
	public ArrayList<String> Attributetype = new ArrayList<String>();
	
}
