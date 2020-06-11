using logWriter;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Security.Cryptography.X509Certificates;

namespace RcaTest
{
    public class Tests
    {
        public string ts = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss:ffff");
        public LogLevel ll = LogLevel.Info;
        public string cn = "testCn";
        public string mn = "testMn";
        public string ccn = "testCcn";
        readonly Object[] att = null;
        public List<String> atty = null;
       
        [SetUp]
        public void Setup()
        {

        }

        [Test]
        public void Test1()
        {
            LogMessage TestMessage = new LogMessage(ll, ts, cn, mn, ccn, att, atty);

            Assert.AreEqual(ts,TestMessage.TimeStamp);
            Assert.AreEqual(ll, TestMessage.LogLvl);
            Assert.AreEqual(cn, TestMessage.ClassName);
            Assert.AreEqual(mn, TestMessage.MethodName);
            Assert.AreEqual(ccn, TestMessage.CallingClassName);
            Assert.AreEqual(att, TestMessage.Attributes);
            Assert.AreEqual(atty, TestMessage.AttributeType);
        }

        [Test]
        public void Test2()
        {
            LogMessage TestMessage = new LogMessage(ll, ts, cn, mn, ccn, att, atty);
            Assert.AreEqual(0, TestMessage.Exceptions.Count);
            TestMessage.LogException(new System.NullReferenceException(""));
            Assert.AreEqual(1, TestMessage.Exceptions.Count);
        }
    }
}