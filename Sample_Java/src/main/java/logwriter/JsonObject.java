package logwriter;
import java.util.ArrayList;


public class JsonObject {
	    String timestamp;
	    String classname;
	    String methodname;
	    String callingclassname;
	    Object attributes;
	    Object attributetype;
	    Exception e;
	    String loglevel;

	    public JsonObject(String loglevel,String timestamp,String classname,String methodname,String callingclassname,ArrayList<Object> attributes,ArrayList<Object> attributetype,int temp,Exception e) {
	    	this.loglevel=loglevel;
	    	this.timestamp = timestamp;
	    	this.callingclassname = callingclassname;
	    	this.classname = classname;
	    	this.methodname = methodname;
	    	this.attributes=attributes.clone();
	    	this.attributetype=attributetype.clone();
	    	this.e=e;

	    }

}


