package unimore.t4.Heimdall.PreProcessing;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

class LogWriterTest {
    Map<String,Object> map = null ;
    private String dirDstLog = "src/test/java/unimore/t4/Heimdall/PreProcessing/writetest" ;

    /**
     * Il metodo list() di File ritorna un array di String contenente i nomi dei file
     * o cartelle che contiene una directory.
     * Ti basta quindi verificare che nomecartella.list().lenght sia uguale a zero
     */
    @Test
    void writeLogtest() {
        LogWriter lw = new LogWriter(dirDstLog) ;
        lw.writeLog(map,"fileTesting");
        File directory = new File("src/test/java/unimore/t4/Heimdall/PreProcessing/writetest") ;
         File[] files = directory.listFiles();

// Definiamo il path della cartella
       // String folderPath = "C:/src/test/java/unimore/t4/Heimdall/PreProcessing";
// Inizializziamo il file
       // File folder = new File(folderPath);
// Verifichiamo che questo sia esistente e che sia una cartella
        boolean existsFolder = directory.isDirectory();
      if (existsFolder){
          System.err.println("errore");
      }else{
          System.out.println("tutto ok");
      }
    }
}