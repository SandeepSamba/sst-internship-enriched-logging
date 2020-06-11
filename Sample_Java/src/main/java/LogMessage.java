import java.util.ArrayList;

//decorator pattern concrete class
public class LogMessage implements logger{
		String TimeStamp = "";
		String ClassName = "";
		String MethodName = "";
		String CallingClassName="";
		ArrayList<Object> Attributes = new ArrayList<Object>();
		ArrayList<Object> Attributetype = new ArrayList<Object>();
		Exception e= null;
		public LogMessage() {
			// TODO Auto-generated constructor stub
		}
		public LogMessage(String timestamp,String classname,String methodname,String callingclassname,ArrayList<Object> attributes,ArrayList<Object> attributetype,Exception e) {
			this.TimeStamp=timestamp;
			this.ClassName=classname;
			this.MethodName=methodname;
			this.CallingClassName=callingclassname;
			this.Attributes=attributes;
			this.Attributetype=attributetype;
			this.e=e;
			
			
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
		public ArrayList<Object> attributes() {
			return Attributes;
			
		}
		public  ArrayList<Object> attributetypes() {
			return Attributetype ;
			
		}
		public Exception exception() {
			return e;
		}
	

}
