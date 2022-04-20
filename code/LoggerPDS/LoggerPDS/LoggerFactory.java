package LoggerPDS;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;


@SuppressWarnings("serial")
public class LoggerFactory implements Serializable {

    private static final Logger defaultLogger = Logger.getLogger( "default" );

    private static String LOG_PATH = ".";

    /* Mappa di logger */
    private static  Map<String, Logger> loggers = new ConcurrentHashMap<String, Logger>();

    //-------------------------------------------------------------------------------------------

    public static Logger getLogger( LogConfiguration config ) {
        System.out.println("ciao mondo") ;
         Logger logger = loggers.get( config.key );
        if ( logger == null ) {
            try {
                logger = createLogger( config );
                loggers.put( config.key, logger );

            } catch (IOException e) {
                defaultLogger.severe( e.toString() );
                return defaultLogger;
            }
        }
        return logger;
    }

    //-------------------------------------------------------------------------------------------
    // Private Methods
    //-------------------------------------------------------------------------------------------

    private static synchronized Logger createLogger( LogConfiguration config ) throws SecurityException, IOException {
        /* Creo il logger */
        Logger logger = Logger.getLogger( config.key );

        Handler fileHandler = createHandler( config );

        logger.addHandler( fileHandler );

        return logger;
    }

    //-------------------------------------------------------------------------------------------

    private static Handler createHandler( LogConfiguration config ) throws SecurityException, IOException {
        Handler fileHandler = new FileHandler(
                LOG_PATH + "/" + config.key + ".log",
                config.limit,
                config.number,
                true);

        fileHandler.setFormatter( config.formatter );
        fileHandler.setLevel( config.level );

        return fileHandler;
    }
}