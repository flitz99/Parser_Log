package unimore.t4.Heimdall.PreProcessing;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {

    @Test
    void writeOnJson() {

        Map<String, Object> captureMap = new HashMap<String, Object>() ;
        captureMap.put("test", 1) ;
        String name = "name" ;
        String dirDstJsonName = "File_Json" ;
        JsonWriter jw = new JsonWriter(dirDstJsonName) ;
        jw.writeOnJson( captureMap , name );
        // crea il file nella directory richiesta
    }



}