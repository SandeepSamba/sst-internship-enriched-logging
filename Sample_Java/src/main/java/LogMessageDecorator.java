import java.util.ArrayList;

public class LogMessageDecorator extends LogDecorator {
	public LogMessageDecorator(logger logger1) {
		// TODO Auto-generated constructor stub
		super(logger1);
		
	}
	public String timestamp() {
		
		return TimeStamp;
		
	}
	public String classname() {
		return ClassName;
		
	}
	public String methodname() {
		return MethodName;
		
	}
	public String callingclassname() {
		return CallingClassName;
		
	}
	public ArrayList<String> attributes() {
		return Attributes;
		
	}
	public  ArrayList<String> attributetypes() {
		return Attributetype ;
		
	}
	
	public void GetMessage() {
		System.out.println("get message");
	}
	public void SetMessage() {
		System.out.println("set message");
	}


}
