import java.util.ArrayList;

public class Jsonobject {
	    String timestamp;
	    String classname;
	    String methodname;
	    String callingclassname;
	    ArrayList<attributeclass> attributes;
	    ArrayList<attributetypes> attributetype;
	    ArrayList<Object> temp;
	    
	    public Jsonobject(String timestamp,String classname,String methodname,String callingclassname,ArrayList<Object> attributes,ArrayList<String> attributetype,int temp) {
	    	this.timestamp = timestamp;
	    	this.callingclassname = callingclassname;
	    	this.classname = classname;
	    	this.methodname = methodname;
	    	for(int i = 0;i<temp;i++) {
	    		this.attributes.add(new attributeclass(attributes.get(i)));
		    	this.attributetype.add(new attributetypes(attributetype.get(i)));
	    	} 
	    		    	

	    }

}


