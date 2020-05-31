﻿using System;
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
        /*private static readonly Logger Mysameplelogger =
         LogManager.GetCurrentClassLogger();*/

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
        [Rca]
        public static int TestImplementation(int a, int b)
        {
            /*LogMessage nLogMessage = new LogMessage(DateTime.Now.ToString(),"My Test Class Name", "My Test Method Name", "My Test Calling Class Name",null,null);
            LogMessageDecorator nLogMessageDecorator = new LogMessageDecorator(nLogMessage);
            Console.WriteLine("Class Name : {0}", nLogMessageDecorator.ClassName);*/
            return a + b;
        }

        [Rca]
        private static string LogSample(string a, string b, string c)
        {

            return a + b + c;


        }

    }
    
    [AttributeUsage(AttributeTargets.Method | AttributeTargets.Constructor | AttributeTargets.Assembly | AttributeTargets.Module)]
    public class RcaAttribute : Attribute, IMethodDecorator
    {
        public string methodName;
        public string jsonMessage;
        public LogMessage messageData;
        public LogMessageDecorator decoratedMessage;
        public void Init(object instance, MethodBase method, object[] args)
        {
            //Console.WriteLine(string.Format("Init: {0} [{1}]", method.DeclaringType.FullName + "." + method.Name, args.Length));
            this.methodName = method.Name;

            messageData = new LogMessage(DateTime.Now.ToString(), method.DeclaringType.FullName, method.Name, method.ReflectedType.Name,args);
            decoratedMessage = new LogMessageDecorator(messageData);
            var options = new JsonSerializerOptions
            {
                WriteIndented = true,
            };
            jsonMessage = JsonSerializer.Serialize(decoratedMessage,options);


        }

        public void OnEntry()
        {
            //Console.WriteLine("Entering Method {0}",methodName);
            /*Console.WriteLine("Time Stamp: {0} ",messageData.TimeStamp.ToString());
            Console.WriteLine("Class Name: {0} ",messageData.ClassName);
            Console.WriteLine("Method Name: {0} ", messageData.MethodName);
            Console.WriteLine("Calling Class Name: {0} ",messageData.CallingClassName);
            Console.WriteLine("Parameters List: ");
            foreach (object p in messageData.Attributes)
            {
                Console.WriteLine("\t{0} ", p.ToString());
            }
            Console.WriteLine("\n");*/

        }

        public void OnException(Exception exception)
        {
            throw new NotImplementedException();
        }

        public void OnExit()
        {
            //Console.WriteLine("Exiting Method {0} ", methodName);
            decoratedMessage.AppendToFile(jsonMessage);
            Console.WriteLine("\n");
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
        object[] Attributes { get; }
    }
    public class LogMessage : ILogger
    {
        public string TimeStamp { get; set; }
        public string ClassName { get; set; }
        public string MethodName { get; set; }
        public string CallingClassName { get; set; }
        public object[] Attributes { get; set; }
        

        public LogMessage()
        {

        }

        public LogMessage(string timeStamp, string className, string methodName,
            string callingClassName, object[] attributes)
        {
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
            //TODO : Logic to get message from the code
            Console.WriteLine("Appending log message to file");
            /* Mysameplelogger.Info(message);*/
            Console.WriteLine(message);

           
        }
        
    }

}
