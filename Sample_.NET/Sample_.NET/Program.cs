using System;
using System.Collections.Generic;
using System.Text.Json;

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
        public List<String> Exceptions { get; set; }

        // Constructor to be use while instantiation this class with the message 
        public LogMessage(LogLevel logLevel,string timeStamp, string className, string methodName,
            string callingClassName, object[] attributes)
        {
            this.LogLvl = logLevel;
            this.TimeStamp = timeStamp;
            this.ClassName = className;
            this.MethodName = methodName;
            this.CallingClassName = callingClassName;
            this.Attributes = attributes;
            this.Exceptions = new List<String>();
        }

        // method to add the exceptions to a list 
        public void LogException(Exception exception)
        {

            Exceptions.Add(exception.Message);
            
        }

        // method to serialize the log message and append the message to file
        public void AppendToFile(LogMessage message)
        {
            // option to customize the indentation of the json nessage object
            var options = new JsonSerializerOptions
            {
                WriteIndented = true,
            };
           Console.WriteLine(JsonSerializer.Serialize(message, options));
        }

    }    
}
