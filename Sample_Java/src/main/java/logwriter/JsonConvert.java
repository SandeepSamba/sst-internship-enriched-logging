package logwriter;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
public class JsonConvert {

	

	public String convert(String loglevel,String timestamp,String classname,String methodname,String callingclassname,ArrayList<Object> attributes,ArrayList<Object> attributetype,int temp,Exception e) {

		JsonObject jsonobj = new JsonObject(loglevel,timestamp,classname, methodname,
				callingclassname,attributes,attributetype,temp,e);
		// Declaring a Gson object
		Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create(); ;
		// Converting the details to JSON format
		String Json = gson.toJson(jsonobj);  
		
			
		return Json;
	}

}
