package LoggerPDS;


import java.util.logging.Level;
import java.util.logging.Logger;
import LoggerPDS.api.*;

public class Main {

    private static final String KEY1 = "01234";
    private static final String KEY2 = "56789";

    public static void main(String[] args) {
/**
 * in pratica il ain legge il file log originale linea per linea ogni linea viene mandata al logger
 */
       /* LogConfiguration conf1 = LogConfiguration.instance( KEY1 );
        Logger logger1 = LoggerFactory.getLogger( conf1 );

        logger1.info( "INFO message for key " + KEY1 );
        logger1.severe( "ERROR message for key " + KEY1 );

        LogConfiguration conf2 = LogConfiguration.instance( KEY2 ).level( Level.SEVERE ).limit(300);
        Logger logger2 = LoggerFactory.getLogger( conf2 );

        logger2.info( "INFO message for key " + KEY2 );
        logger2.severe( "ERROR message for key " + KEY2 );

    */
        try{
            Reader lettore = new Reader("/Users/jacopovecchi/PDS/2022t4/code/LoggerPDS/LoggerPDS/01234.log.0");
            System.out.println( " inizio stampa ");
           lettore.ReaderLine();

        }catch (Exception e){

        }


    }


}