//import java.util.ArrayList;

public abstract class LogDecorator implements logger{
	public LogDecorator() {
		// TODO Auto-generated constructor stub
	}
	protected logger _logger;

	public LogDecorator(logger _logger) {
		super();
			this._logger=_logger;
		
		//System.out.println(_logger.getClass());
	}
//	public logger get_logger() {
//		return _logger;
//	}
//	public void set_logger(logger _logger) {
//		this._logger = _logger;
//	}
//	public String TimeStamp = logger.TimeStamp;  
//	
//	public String ClassName = logger.ClassName;
//	public String MethodName = logger.MethodName;
//	public String CallingClassName = logger.CallingClassName;
//	public ArrayList<String> Attributes = logger.Attributes;
//	public ArrayList<String> AttributeTypes = logger.Attributetype;
}
