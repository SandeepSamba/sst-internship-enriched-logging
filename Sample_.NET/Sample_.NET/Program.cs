using System;
using System.Text.Json;

namespace logWriter
{
    public class LogMessage
    {
        public LogLevel LogLvl { get; set; }
        public string TimeStamp { get; set; }
        public string ClassName { get; set; }
        public string MethodName { get; set; }
        public string CallingClassName { get; set; }
        public object[] Attributes { get; set; }
        
        public LogMessage(LogLevel logLevel,string timeStamp, string className, string methodName,
            string callingClassName, object[] attributes)
        {
            this.LogLvl = logLevel;
            this.TimeStamp = timeStamp;
            this.ClassName = className;
            this.MethodName = methodName;
            this.CallingClassName = callingClassName;
            this.Attributes = attributes;
        }

        public void AppendToFile(LogMessage message)
        {
            var options = new JsonSerializerOptions
            {
                WriteIndented = true,
            };
           Console.WriteLine(JsonSerializer.Serialize(message, options));
        }

    }    
}
