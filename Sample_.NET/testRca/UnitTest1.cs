using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using logWriter;
using System.Collections.Generic;

namespace testRca
{

    [TestClass]
    public class UnitTest1
    {
        public string ts = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss:ffff");
        public LogLevel ll = LogLevel.Info;
        public string cn = "testCn";
        public string mn = "testMn";
        public string ccn = "testCcn";
        readonly Object[] att = null;
        public List<String> atty = null;

        [TestMethod]
        public void TestMethod1()
        {
            LogMessage TestMessage = new LogMessage(ll, ts, cn, mn, ccn, att, atty);

            Assert.AreEqual(ts, TestMessage.TimeStamp);
            Assert.AreEqual(ll, TestMessage.LogLvl);
            Assert.AreEqual(cn, TestMessage.ClassName);
            Assert.AreEqual(mn, TestMessage.MethodName);
            Assert.AreEqual(ccn, TestMessage.CallingClassName);
            Assert.AreEqual(att, TestMessage.Attributes);
            Assert.AreEqual(atty, TestMessage.AttributeType);
        }

        [TestMethod]
        public void TestMethod2()
        {
            LogMessage TestMessage = new LogMessage(ll, ts, cn, mn, ccn, att, atty);
            Assert.AreEqual(0, TestMessage.Exceptions.Count);
            TestMessage.LogException(new System.NullReferenceException(""));
            Assert.AreEqual(1, TestMessage.Exceptions.Count);
        }


        }
}
