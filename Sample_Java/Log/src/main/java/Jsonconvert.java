import java.util.ArrayList;

import com.google.gson.Gson;
public class Jsonconvert {

	
	public String convert(String timestamp,String classname,String methodname,String callingclassname,ArrayList<Object> attributes,ArrayList<String> attributetype,int temp) {
		
		Jsonobject jsonobj = new Jsonobject(timestamp,classname, methodname,
				callingclassname,attributes,attributetype,temp);
		Gson gson = new Gson();
		String Json = gson.toJson(jsonobj);  
		
			
		return Json;
	}

}
