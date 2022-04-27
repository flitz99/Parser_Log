package LoggerPDS;

import java.util.logging.Formatter;
import java.util.logging.Level;

class LogConfiguration {

    // the log key
    protected String key;

    // limit  the maximum number of bytes to write to any one file
    protected int limit 	= 1000;

    // the number of files to use
    protected int number	= 2;

    // the log level
    protected Level level 	= Level.ALL;

    // the log formatter
    protected Formatter formatter 	= new BaseFormatter();

    private LogConfiguration() {}

    public static LogConfiguration instance( String key ) {
        LogConfiguration config = new LogConfiguration();
        config.key = key;
        return config;
    }

    public LogConfiguration limit(int limit) {
        this.limit = limit;
        return this;
    }

    public LogConfiguration number(int number) {
        this.number = number;
        return this;
    }

    public LogConfiguration level(Level level) {
        this.level = level;
        return this;
    }

    public LogConfiguration formatter(Formatter formatter) {
        this.formatter = formatter;
        return this;
    }
}