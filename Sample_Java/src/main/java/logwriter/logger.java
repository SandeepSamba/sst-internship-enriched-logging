package logwriter;
import java.util.ArrayList;
//decorator pattern interface declaring logger fields
public interface logger {
	public String TimeStamp = "";
	public String ClassName = "";
	public String MethodName = "";
	public String CallingClassName="";
	public ArrayList<Object> Attributes = new ArrayList<Object>();
	public ArrayList<String> Attributetype = new ArrayList<String>();
	public Exception e=null;

}
