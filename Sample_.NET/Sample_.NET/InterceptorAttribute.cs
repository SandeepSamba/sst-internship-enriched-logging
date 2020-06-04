using System;
using System.Reflection;
using MethodDecorator.Fody.Interfaces;

namespace logWriter
{
    /*
     * 
     * Interceptor Attribute:
     * This attribute intercepts the methods on which it is used
     * The attribute invokes 4 methods on the target it is tagged with
     *
     * Usage:
     * The attribute([Rca]) needs to be tagged to the target that has to be logged
     * The default log level is Info, this log level can be overridden by attaching 
     *      the desired level wih the target
     *      Example: to set the log level as 'Warning'
     *          [Rca(Level = LogLevel.Warn)]
     *               
     */

    // Setting the targets
    [AttributeUsage(AttributeTargets.Method | AttributeTargets.Constructor
        | AttributeTargets.Assembly | AttributeTargets.Module)]
    public class RcaAttribute : Attribute, IMethodDecorator
    {
        public LogMessage messageData;
        public LogLevel level = LogLevel.Info;

        // Logic to oerride the default log level if specified by the user
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


        // Init - Triggered when the target is initialized
        public void Init(object instance, MethodBase method, object[] args)
        {
            //Logic to collect the instance of the target and retrieve the messsage to be logged
            messageData = new LogMessage(Level, DateTime.Now.ToString(), method.DeclaringType.FullName,
                method.Name, method.ReflectedType.Name, args);

        }

        // OnEntry - Triggered when the target is entered
        public void OnEntry()
        {
            //Logic to do the activities when the target is entered

        }

        // OnException - Triggered when an exception occures in the target
        public void OnException(Exception exception)
        {
            //Logic to log the exception
            messageData.LogException(exception);
            messageData.AppendToFile(messageData);
        }

        //  OnExit - Triggered when the target is exited
        public void OnExit()
        {
            //Logic to append the log message to the file when the target is exited
            messageData.AppendToFile(messageData);
        }
    }
}