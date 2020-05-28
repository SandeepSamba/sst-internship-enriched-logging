using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NLog;

namespace nlogexampe
{
    class Program
    {
        private static Logger Mysameplelogger =
         LogManager.GetCurrentClassLogger();
        static void Main(string[] args)
        {
            LogSample();
        }

        static void LogSample()
        {

            Mysameplelogger.Info("ss");


        }
    }
}
