package LoggerPDS;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final String KEY1 = "01234";
    private static final String KEY2 = "56789";

    public static void main(String[] args) {

        LogConfiguration conf1 = LogConfiguration.instance( KEY1 );
        Logger logger1 = LoggerFactory.getLogger( conf1 );

        logger1.info( "INFO message for key " + KEY1 );
        logger1.severe( "ERROR message for key " + KEY1 );

        LogConfiguration conf2 = LogConfiguration.instance( KEY2 ).level( Level.SEVERE ).limit(300);
        Logger logger2 = LoggerFactory.getLogger( conf2 );

        logger2.info( "INFO message for key " + KEY2 );
        logger2.severe( "ERROR message for key " + KEY2 );
    }

}