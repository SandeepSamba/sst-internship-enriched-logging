using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using logWriter;
using NLog;
using NLog.Fluent;

namespace nlogexampe
{
    class Program
    {
        private static readonly Logger Mysameplelogger =
         LogManager.GetCurrentClassLogger();

        private static void Main(string[] args)
        {
            if (args is null)
            {
                throw new ArgumentNullException(nameof(args));
            }

            LogSample();
            TestImplementation();
        }

        static void TestImplementation()
        {
            LogMessage nLogMessage = new LogMessage(DateTime.Now.ToString(),"My Test Class Name", "My Test Method Name", "My Test Calling Class Name",null,null);
            LogMessageDecorator nLogMessageDecorator = new LogMessageDecorator(nLogMessage);
            Console.WriteLine("Class Name : {0}", nLogMessageDecorator.ClassName);
        }

        static void LogSample()
        {

            Mysameplelogger.Info("ss");


        }

    }
}

namespace logWriter
{
    public interface ILogger
    {
        string TimeStamp { get; }
        string ClassName { get; }
        string MethodName { get; }
        string CallingClassName { get; }
        List<string> Attributes { get; }
        List<string> AttributesDataType { get; }
    }
    public class LogMessage : ILogger
    {
        public string TimeStamp { get; set; }
        public string ClassName { get; set; }
        public string MethodName { get; set; }
        public string CallingClassName { get; set; }
        public List<string> Attributes { get; set; }
        public List<string> AttributesDataType { get; set; }

        public LogMessage()
        {

        }

        public LogMessage(string timeStamp, string className, string methodName,
            string callingClassName, List<string> attributes, List<string> attributesDataType)
        {
            this.TimeStamp = timeStamp;
            this.ClassName = className;
            this.MethodName = methodName;
            this.CallingClassName = callingClassName;
            this.Attributes = attributes;
            this.AttributesDataType = attributesDataType;
        }

    }

    public abstract class LogDecorator : ILogger
    {
        private readonly ILogger _logger;
        public LogDecorator(ILogger nlogger)
        {
            _logger = nlogger;
        }

        public string TimeStamp => _logger.TimeStamp;

        public string ClassName => _logger.ClassName;

        public string MethodName => _logger.MethodName;

        public string CallingClassName => _logger.CallingClassName;

        public List<string> Attributes => _logger.Attributes;

        public List<string> AttributesDataType => _logger.AttributesDataType;
    }

    public class LogMessageDecorator : LogDecorator
    {
        public LogMessageDecorator(ILogger nlogger) : base(nlogger) { }

        public void GetMessage()
        {
            //TODO : Logic to get message from the code
            Console.WriteLine("Inside get message");
           
        }
        public void SetMessage()
        {
            //TODO : Logic to set the message to the object
            Console.WriteLine("setting message");
        }
    }

}
