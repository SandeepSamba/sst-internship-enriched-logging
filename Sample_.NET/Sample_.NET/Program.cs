using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using logWriter;
using MethodDecorator.Fody.Interfaces;
using NLog;
using NLog.Fluent;
using System.Text.Json;


namespace nlogexampe
{
    public class Program
    {
        [Rca]
        private static void Main(string[] args)
        {
            if (args is null)
            {
                throw new ArgumentNullException(nameof(args));
            }

            LogSample("Route","Cause","Analysis");
            TestImplementation(1,2);
        }
        [Rca(Level ="Debug")]
        public static int TestImplementation(int a, int b)
        {
            return a + b;
        }

        [Rca]
        private static string LogSample(string a, string b, string c)
        {

            return a + b + c;


        }

    }

}

namespace logWriter
{
    [AttributeUsage(AttributeTargets.Method | AttributeTargets.Constructor
        | AttributeTargets.Assembly | AttributeTargets.Module)]
    public class RcaAttribute : Attribute, IMethodDecorator
    {
        public string jsonMessage;
        public LogMessage messageData;
        public LogMessageDecorator decoratedMessage;
        public string LogLevel = "INFO";

        public string Level
        {
            get
            {
                return LogLevel;
            }
            set
            {
                LogLevel = value.ToUpper();
            }
        }



        public void Init(object instance, MethodBase method, object[] args)
        {
            messageData = new LogMessage(Level, DateTime.Now.ToString(), method.DeclaringType.FullName,
                method.Name, method.ReflectedType.Name, args);
            decoratedMessage = new LogMessageDecorator(messageData);
            var options = new JsonSerializerOptions
            {
                WriteIndented = true,
            };
            jsonMessage = JsonSerializer.Serialize(decoratedMessage, options);


        }

        public void OnEntry()
        {

        }

        public void OnException(Exception exception)
        {
            throw new NotImplementedException();
        }

        public void OnExit()
        {
            decoratedMessage.AppendToFile(jsonMessage);
        }
    }
    public interface ILogger
    {
        string LogLevel{ get;}
        string TimeStamp { get; }
        string ClassName { get; }
        string MethodName { get; }
        string CallingClassName { get; }
        object[] Attributes { get; }
    }
    public class LogMessage : ILogger
    {
        public string LogLevel { get; set; }
        public string TimeStamp { get; set; }
        public string ClassName { get; set; }
        public string MethodName { get; set; }
        public string CallingClassName { get; set; }
        public object[] Attributes { get; set; }
        

        public LogMessage()
        {

        }

        public LogMessage(string logLevel,string timeStamp, string className, string methodName,
            string callingClassName, object[] attributes)
        {
            this.LogLevel = logLevel;
            this.TimeStamp = timeStamp;
            this.ClassName = className;
            this.MethodName = methodName;
            this.CallingClassName = callingClassName;
            this.Attributes = attributes;
        }

    }

    public abstract class LogDecorator : ILogger
    {
        private readonly ILogger _logger;
        public LogDecorator(ILogger nlogger)
        {
            _logger = nlogger;
        }
        public string LogLevel => _logger.LogLevel;
        public string TimeStamp => _logger.TimeStamp;

        public string ClassName => _logger.ClassName;

        public string MethodName => _logger.MethodName;

        public string CallingClassName => _logger.CallingClassName;

        public object[] Attributes => _logger.Attributes;

    }

    public class LogMessageDecorator : LogDecorator
    {
        public LogMessageDecorator(ILogger nlogger) : base(nlogger) { }
        private static readonly Logger Mysameplelogger =
         LogManager.GetCurrentClassLogger();

        public void AppendToFile(string message)
        {
            //TODO : FILE APPENDING AFTER ENRICHING
            Console.WriteLine(message+"\n");

           
        }
        
    }

}
