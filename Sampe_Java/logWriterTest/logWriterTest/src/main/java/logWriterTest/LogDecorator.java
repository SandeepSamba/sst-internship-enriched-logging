package logWriterTest;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.apache.log4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@SuppressWarnings("unused")
public abstract class LogDecorator implements Logger{
	
	private Logger _logger;

	public LogDecorator(Logger logger1) {
	
		this._logger=logger1;
		//System.out.println(logger1.getClass());
	}
//	public LogDecorator() {
//		return _logger.ClassName;
//	}
	public String TimeStamp = _logger.TimeStamp;
//
//    public String ClassName = _logger.ClassName;
//
//    public String MethodName = logger.MethodName;
//
//    public STRING CallingClassName = logger.CallingClassName;

    
}
