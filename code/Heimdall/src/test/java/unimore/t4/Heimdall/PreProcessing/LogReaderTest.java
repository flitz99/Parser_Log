package unimore.t4.Heimdall.PreProcessing;

import org.junit.jupiter.api.Test;

import java.io.File;

class LogReaderTest {
    LogParser logp = new LogParser(null,null);
    
    @Test
    void logReader() {
        LogReader LR = new LogReader(null, null);
        if (LR.equals(null)) {
            System.out.println("Test riuscito");
        }
        else {
            System.err.println("Test non riuscito");
        }
    }

    @Test
    void readAllLogFile() {
        LogReader lR = new LogReader("/Users/jacopovecchi/PDS/2022t4/code/Heimdall/src/test/java/unimore/t4/Heimdall/todelete",logp);
        lR.readAllLogFile();
        if (lR.equals(null)){
            System.out.println("creato oggeto nullo ");
        }
    }
}