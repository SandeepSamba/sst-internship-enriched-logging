using Newtonsoft.Json;
using NLog;
using NLog.Fluent;
using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;

namespace logWriter
{
    /*
     *      The class to store the log message and carry out 
     *      the file appending operations
     */
    public class LogMessage
    {
        public LogLevel LogLvl { get; set; }
        public string TimeStamp { get; set; }
        public string ClassName { get; set; }
        public string MethodName { get; set; }
        public string CallingClassName { get; set; }
        public object[] Attributes { get; set; }
        public List<String> AttributeType { get; set; }
        public List<String> Exceptions { get; set; }

        // Constructor to be use while instantiation this class with the message 
        public LogMessage(LogLevel logLevel,string timeStamp, string className, string methodName,
            string callingClassName, object[] attributes, List<String> attributeType)
        {
            this.LogLvl = logLevel;
            this.TimeStamp = timeStamp;
            this.ClassName = className;
            this.MethodName = methodName;
            this.CallingClassName = callingClassName;
            this.Attributes = attributes;
            this.AttributeType = attributeType;
            this.Exceptions = new List<String>();
        }

        // method to add the exceptions to a list 
        public void LogException(Exception exception)
        {

            Exceptions.Add(exception.ToString());
            
        }

        // method to serialize the log message and append the message to file
        public void AppendToFile(LogMessage message)
        {
            Logger logger = LogManager.GetCurrentClassLogger();
            // option to customize the indentation of the json nessage object

            /*
             * Uncomment this part of the code below to print the log message onto the console
             * 
             * //Console.WriteLine(JsonConvert.SerializeObject(message,Formatting.Indented));
             * 
             * 
             */


            //logic to write the log message to the file
            //To configure the file, modify the details in the fileConfig.cs file
            logger.Info(JsonConvert.SerializeObject(message, Formatting.Indented));

        }

    }    
}
