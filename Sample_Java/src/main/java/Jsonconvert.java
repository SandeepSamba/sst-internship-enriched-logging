import java.util.ArrayList;

import com.google.gson.Gson;
public class Jsonconvert {

	

	public String convert(String timestamp,String classname,String methodname,String callingclassname,ArrayList<Object> attributes,ArrayList<Object> attributetype,int temp) {

		Jsonobject jsonobj = new Jsonobject(timestamp,classname, methodname,
				callingclassname,attributes,attributetype,temp);
		// Declaring a Gson object
		Gson gson = new Gson();
		// Converting the details to JSON format
		String Json = gson.toJson(jsonobj);  
		
			
		return Json;
	}

}
