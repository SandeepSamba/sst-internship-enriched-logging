//decorator pattern abstract class
public abstract class LogDecorator implements logger{
	public LogDecorator() {
		// TODO Auto-generated constructor stub
	}
	protected logger _logger;

	public LogDecorator(logger _logger) {
		super();
			this._logger=_logger;
		
		
	}

}
