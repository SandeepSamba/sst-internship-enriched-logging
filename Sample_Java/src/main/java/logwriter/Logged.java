package logwriter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Definition of @Timed annotation
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)

public @interface Logged {
	 //public String level() default "INFO";
	LogEnum level() default LogEnum.INFO;
}
