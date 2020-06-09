import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
/* Pointcut - Determines that every method with the annotation @Timed needs to be intercepted
Joint point - Method ExampleAspect() is executed when the pointcut is met
Logger - A logger with class name Main is created
The retrieved details are further assigned to a Jsonconv object
The information is then logged in JSON format to a file */
@Aspect
public class ExampleAspect {
	@Before("execution(* *(..))")
	public Object logBefore(JoinPoint joinPoint) throws Throwable {
		Object proceed = ((ProceedingJoinPoint) joinPoint).proceed();
		System.out.println("logBefore() is running!");	 
		Logger logger = Logger.getLogger(Main.class);
	
		final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		final Method method = signature.getMethod();	
		reflect reft = new reflect(method);
		ArrayList<Object> Attributes = new ArrayList<Object>();
		ArrayList<Object> types= new ArrayList<Object>();
		Attributes.add(joinPoint.getArgs()[0]);
		Attributes.add(joinPoint.getArgs()[1]);
		types = reft.get_arg_type(joinPoint.getSignature().getName());
	    String callingclass = Thread.currentThread().getName();
	    String classname = "" + joinPoint.getSignature().getDeclaringType(); 
		String methodname=joinPoint.getSignature().getName();
		String sec=""+System.currentTimeMillis();
	    LogMessage logmessage = new LogMessage(sec,classname,methodname,callingclass,Attributes,types) ;
	    int temp=logmessage.Attributes.size();
        Jsonconvert jsonconv = new Jsonconvert();
        String log = jsonconv.convert(logmessage.timestamp(),logmessage.classname(),logmessage.methodname(),logmessage.callingclassname(),logmessage.attributes(),logmessage.attributetypes(),temp);
      
		logger.info(log);		
        return proceed;

	}
	
	// for exception logging//
    @AfterThrowing(value = "execution(* *(..))", throwing="e")
    public void logExceptionHandler(JoinPoint joinPoint,Exception e) throws Throwable {
		System.out.println("logExceptionHandler() is running!");
    	final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		final Method method = signature.getMethod();
    	reflect reft = new reflect(method);
		ArrayList<Object> types= new ArrayList<Object>();
		types = reft.get_arg_type(joinPoint.getSignature().getName());
	    String t = Thread.currentThread().getName();
    	System.out.println("Exception e is <" + e + ">");
		
    	
    }
    


}


