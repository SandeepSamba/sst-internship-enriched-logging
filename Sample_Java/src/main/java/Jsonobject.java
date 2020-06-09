import java.util.ArrayList;


public class Jsonobject {
	    String timestamp;
	    String classname;
	    String methodname;
	    String callingclassname;
	    Object attributes;
	    Object attributetype;
	    

	    public Jsonobject(String timestamp,String classname,String methodname,String callingclassname,ArrayList<Object> attributes,ArrayList<Object> attributetype,int temp) {

	    	this.timestamp = timestamp;
	    	this.callingclassname = callingclassname;
	    	this.classname = classname;
	    	this.methodname = methodname;
	    	this.attributes=attributes.clone();
	    	this.attributetype=attributetype.clone();	    		    	

	    }

}


