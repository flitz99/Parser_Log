package unimore.t4.Heimdall.PreProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/**
 * classe che serve per deserializzare un file di log,
 * ognuno inserito in una mappa e tutte contenute in un arraylist
 */
public class JsonReader {
    //prende in input il nome della cartella di logJson
    //deserializza ogni file di log
    //ogni linea del file è un oggetto json, viene letto e messo in una mappa
    //ogni mappa può essere messa in un arraylist
    private final ObjectMapper mapper = new ObjectMapper();
    private final File dirSrcJson;

    public JsonReader(String dirSrcJsonName){
        dirSrcJson = new File(new File("").getAbsolutePath()+File.separator+dirSrcJsonName);
        dirSrcJson.mkdir();
    }

    public void readFromJson(){

    }
}
