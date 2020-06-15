﻿using NLog;
using NLog.Targets;
using System;
using System.IO;

namespace logWriter
{
    /*
     * This class manages the file configuration 
     * 
     * To change the file configuration set the interval/archiveSize value to the 
     *      required interval/archiveSize value from the provided ones or define your own
     *      
     */
    public class FileConfig
    {
        //Diferent intervals after which the new files are created
        public static string Minutely = DateTime.Now.ToString("yyyy-MM-dd_HH-mm");
        public static string Hourly = DateTime.Now.ToString("yyyy-MM-dd_HH");
        public static string Daily = DateTime.Now.ToString("yyyy-MM-dd");
        public static string Monthly = DateTime.Now.ToString("yyyy-MM");
        public static string Yearly = DateTime.Now.ToString("yyyy");

        //Different sizes after which the new files are created
        public static long KB = 1024;
        public static long MB = 1048576;
        public static long GB = 1073741824;

        //Method to update the file configuration
        public static void UpdateConfig()
        {
            //Change this interval to obtain a new file after every interval 
            var interval = Daily;

            //Change the archive size to obtain a new file when the size is exceeded
            var archiveSize = MB;

            //Logic to get the target file
            var configuration = LogManager.Configuration;
            var fileTarget = configuration.FindTargetByName<FileTarget>("jsonFile");

            //logic to obtain a new file after every interval
            fileTarget.FileName = "${basedir}/Logs/log_"+ interval +".json";

            //Logic to obtain a new file after the size is exceeded
            fileTarget.ArchiveAboveSize = archiveSize ;
            fileTarget.ArchiveNumbering = ArchiveNumberingMode.Sequence;
            LogManager.Configuration = configuration; //apply
        }
    }
    
}