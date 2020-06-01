import java.util.ArrayList;

import com.google.gson.Gson;
public class Jsonconvert {

	
	public String convert(String timestamp,String classname,String methodname,String callingclassname,ArrayList<String> attributes,ArrayList<String> attributetype) {
		
		Jsonobject jsonobj = new Jsonobject(timestamp,classname, methodname,
				callingclassname,attributes,attributetype);
		Gson gson = new Gson();
		String Json = gson.toJson(jsonobj);  
		
			
		return Json;
	}

}
