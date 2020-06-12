import java.util.ArrayList;

import org.apache.log4j.Logger;
//import org.apache.logging.log4j.Marker;
//import org.apache.logging.log4j.MarkerManager;
import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;



import java.lang.reflect.Method;
//import java.util.ArrayList;


import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
/* Pointcut - Determines that every method with the annotation @Timed needs to be intercepted
Joint point - Method ExampleAspect() is executed when the pointcut is met
Logger - A logger with class name Main is created
The retrieved details are further assigned to a Jsonconv object
The information is then logged in JSON format to a file for FATAL log level */
@Aspect
public class FatalAspect {
	@Before("execution(* *(..))")
	public Object logBefore(JoinPoint joinPoint) throws Throwable {
		Object proceed = ((ProceedingJoinPoint) joinPoint).proceed();
		System.out.println("logBefore() is running!");	 
		Logger logger = Logger.getLogger(Main.class);
	
	    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();	
		reflect reft = new reflect(method);
		ArrayList<Object> Attributes = new ArrayList<Object>();
		ArrayList<Object> types= new ArrayList<Object>();
		for(int i = 0;i<joinPoint.getArgs().length;i++) {
			Attributes.add(joinPoint.getArgs()[i]);
		}
		types = reft.get_arg_type(joinPoint.getSignature().getName());
	    String callingclass = Thread.currentThread().getName();
	    String classname = "" + joinPoint.getSignature().getDeclaringType(); 
		String methodname=joinPoint.getSignature().getName();
		String sec=""+System.currentTimeMillis();
        Exception e = null;

	    LogMessage logmessage = new LogMessage(sec,classname,methodname,callingclass,Attributes,types,e) ;
	    int temp=logmessage.Attributes.size();
        Jsonconvert jsonconv = new Jsonconvert();
        String log = jsonconv.convert(logmessage.timestamp(),logmessage.classname(),logmessage.methodname(),logmessage.callingclassname(),logmessage.attributes(),logmessage.attributetypes(),temp,logmessage.exception());
        
        logger.fatal(log);		
        return proceed;

	}
	
	// for exception logging//
    @AfterThrowing(value = "execution(* *(..))", throwing="e")
    public void logExceptionHandler(JoinPoint joinPoint,Exception e) throws Throwable {
		Logger logger = Logger.getLogger(Main.class);

		System.out.println("logExceptionHandler() is running!");
    	final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		final Method method = signature.getMethod();
    	reflect reft = new reflect(method);
		ArrayList<Object> types= new ArrayList<Object>();
		ArrayList<Object> Attributes = new ArrayList<Object>();
		for(int i = 0;i<joinPoint.getArgs().length;i++) {
			Attributes.add(joinPoint.getArgs()[i]);
		}
		types = reft.get_arg_type(joinPoint.getSignature().getName());
	    String callingclass = Thread.currentThread().getName();
	    String classname = "" + joinPoint.getSignature().getDeclaringType(); 
		String methodname=joinPoint.getSignature().getName();
		String sec=""+System.currentTimeMillis();
	    LogMessage logmessage = new LogMessage(sec,classname,methodname,callingclass,Attributes,types,e) ;
	    int temp=logmessage.Attributes.size();
        Jsonconvert jsonconv = new Jsonconvert();
        String log = jsonconv.convert(logmessage.timestamp(),logmessage.classname(),logmessage.methodname(),logmessage.callingclassname(),logmessage.attributes(),logmessage.attributetypes(),temp,logmessage.exception());
		logger.fatal(log);
		

    	System.out.println("Exception e is <" + e + ">");
		
    	
    }
    


}

//
//}
