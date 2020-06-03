using System;
using System.Reflection;
using MethodDecorator.Fody.Interfaces;

namespace logWriter
{
    [AttributeUsage(AttributeTargets.Method | AttributeTargets.Constructor
        | AttributeTargets.Assembly | AttributeTargets.Module)]
    public class RcaAttribute : Attribute, IMethodDecorator
    {
        public LogMessage messageData;
        public LogLevel level = LogLevel.Info;

        public LogLevel Level
        {
            get
            {
                return level;
            }
            set
            {
                level = value;
            }
        }

        public void Init(object instance, MethodBase method, object[] args)
        {
            messageData = new LogMessage(Level, DateTime.Now.ToString(), method.DeclaringType.FullName,
                method.Name, method.ReflectedType.Name, args);

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
            messageData.AppendToFile(messageData);
        }
    }
}