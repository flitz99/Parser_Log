package unimore.t4.Heimdall.PreProcessing;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class LogProcessingTest {

    @Test
    void logProcessing() {

        LogProcessing LP = new LogProcessing("c","a","b");
        String dirD = "/Users/jacopovecchi/PDS/2022t4/code/Heimdall/src/test/java/unimore/t4/Heimdall/todelete";
        File pathdaEliminare = new File("src/test/java/unimore/t4/Heimdall/todelete");
        try {
          if (  LP.deleteDirectory(pathdaEliminare)){
              System.out.println("direcotry cancellata");
          }else{
              System.out.println("directory sbagliata");
          }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    /** Test che testa il log processing con una non directory */
    void logProcessing_empty() {
    /**
    * DA NON ESEGUIRE
    */
        LogProcessing LP = new LogProcessing("c","a","b");
        /**
         * La stringa dirD non contiene più il percorso della directory ma una parola.
         */
        String dirD = "stringa";
        File pathdaEliminare = new File("src/test/java/unimore/t4/Heimdall/todelete");
        try {
            LP.deleteDirectory(pathdaEliminare);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /**
         * Dopo che abbiamo fatto partire il test ci siamo ritrovati il codice
         * completamente cancellato.
         * Ribandiamo ancora una volta: ESEGUIRE QUESTO TEST SU UNA COPIA DEL CODICE
         * E NON SU QUELLO ORIGINALE
         */
    }

    @Test
    void logProcessing_preprocessingDirs() {

        /**
         * Metodo che utilizzeremo per testare preprocessingDirs che attualemte non
         * possiamo ancora fare a causa del non superamento del metodo
         * deleteDirectory
         */

    }
}