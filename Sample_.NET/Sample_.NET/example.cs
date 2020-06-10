using System;
using System.Runtime.Remoting;
using System.Threading;
using logWriter;

namespace nlogexampe
{
    /*
     * This file is to be used just for demo purposes
     */
    public class Employee
    {
        private string Name;
        private string Department;
        private string Id;

        [Rca(Level = LogLevel.Trace)]
        public Employee(string name, string department, string id)
        {
            Name = name;
            Department = department;
            Id = id;
        }

        [Rca(Level = LogLevel.Debug)]
        public void DisplayEmp()
        {
            //Displaying Employee details
        }
    }
    public class Calculator
    {
        [Rca]
        public int Add(int a, int b)
        {
            return a + b;
        }
        [Rca]
        public int Subtract(int a, int b)
        {
            return a - b;
        }
        [Rca]
        public int Multiply(int a, int b)
        {
            return a * b;
        }
    }
    public class Program
    {
        [Rca]
        public static void ShowException()
        {
            //Console.WriteLine("Calling from thread");
            int a = 0, b = 1;
            int res = b / a;
        }

        [Rca(Level = LogLevel.Fatal)]
        public static int TestImplementation(int a, int b)
        {
            return a + b;
        }

        [Rca]
        private static string LogSample(string a, string b, string c)
        {
            return a + b + c;
        }


        [Rca]
        private static void Main(string[] args)
        {
            if (args is null)
            {
                throw new ArgumentNullException(nameof(args));
            }
            LogSample("Route", "Cause", "Analysis");
            TestImplementation(1, 2);


            Thread thread = new Thread(Program.ShowException);
            thread.Start();

            Thread thread2 = new Thread(Program.ShowException);
            thread2.Start();

            Calculator calc = new Calculator();
            calc.Add(10, 20);
            calc.Subtract(40, 50);
            calc.Multiply(5, 10);

            Employee testEmp = new Employee("Test Employee Name", "Test Department", "1111");
            testEmp.DisplayEmp();
        }



    }

}