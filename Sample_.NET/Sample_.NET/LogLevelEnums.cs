namespace logWriter
{
    /*
     *      Defining the log levels as Enum as this proviides the user
     *      with the functionality to modify or incorporate new log 
     *      levels between the already existing ones.
     */
    public enum LogLevel
    {
        Trace = 100,
        Debug = 200,
        Info = 300,
        Warn = 400,
        Error = 500,
        Fatal = 600
    }
}