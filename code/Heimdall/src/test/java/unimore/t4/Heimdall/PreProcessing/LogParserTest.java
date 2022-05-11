package unimore.t4.Heimdall.PreProcessing;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LogParserTest {

    @Test
    void matchLogMakeMap() throws IOException {
        String testLog = "93.147.139.239 - - [07/Sep/2021:08:21:07 +0000] \"GET / HTTP/1.1\" 200 40430 \"-\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"\n" ;
        String name = "name";
        LogParser lp = new LogParser( "File_output" , "File_Json" );
        lp.matchLogMakeMap(testLog, name);
        Path path = Paths.get( "/Users/jacopovecchi/PDS/2022t4/code/Heimdall/File_output/name");

        if(path.toFile().isFile()){
            System.out.println(path + " Exists");
        }else{

            System.out.println(path + " Do not Exists");
        }
    }
    
}