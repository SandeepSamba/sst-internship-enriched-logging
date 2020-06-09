//retrieving method parameter types using reflection

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class reflect {
	Method method;
	ArrayList<Object> types= new ArrayList<Object>();
	public reflect(Method methd) {
    	this.method = methd;
    	}
	
	public ArrayList<Object> get_arg_type(String method){
	 
        Parameter parameter[] = this.method.getParameters(); // It returns array of parameters  
        // Iterating parameter array  
        for (Parameter parameter2 : parameter) { 
            types.add(parameter2.getParameterizedType().getTypeName()); // returns type of parameter  
       }
		return types;
	}

}
