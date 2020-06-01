import java.util.ArrayList;


public class LogMessage implements logger{
		String TimeStamp = "";
		String ClassName = "";
		String MethodName = "";
		String CallingClassName="";
		ArrayList<String> Attributes = new ArrayList<String>();
		ArrayList<String> Attributetype = new ArrayList<String>();

		public LogMessage() {
			// TODO Auto-generated constructor stub
		}
		public LogMessage(String timestamp,String classname,String methodname,String callingclassname,ArrayList<String> attributes,ArrayList<String> attributetype) {
			this.TimeStamp=timestamp;
			this.ClassName=classname;
			this.MethodName=methodname;
			this.CallingClassName=callingclassname;
			this.Attributes=attributes;
			this.Attributetype=attributetype;
			//System.out.println(TimeStamp);
			
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
	

}
