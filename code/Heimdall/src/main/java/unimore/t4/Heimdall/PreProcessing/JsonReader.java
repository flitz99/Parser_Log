package unimore.t4.Heimdall.PreProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import unimore.t4.Heimdall.model.LogEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

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
    private final ArrayList<LogEntityJson> logEntityJsonArrayList;

    public JsonReader(String dirSrcJsonName) {
        dirSrcJson = new File(new File("").getAbsolutePath() + File.separator + dirSrcJsonName);
        dirSrcJson.mkdir();
        logEntityJsonArrayList = new ArrayList<>();
    }

    /**
     * metodo che legge tutto un file json e ogni riga, viene letta e convertita
     * in un oggetto logEntityJson, poi inserita nell' arraylist
     */
    public void readFromJsonFile(File jsonLogFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonLogFile = new File(dirSrcJson.getAbsolutePath() + File.separator + "gnetshop.log.1.json");
            BufferedReader br = new BufferedReader(new FileReader(jsonLogFile));
            LogEntityJson logEntityJson = mapper.readValue(br, LogEntityJson.class);
            logEntityJsonArrayList.add(logEntityJson);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<LogEntityJson> getLogEntityJsonArrayList() {
        return logEntityJsonArrayList;
    }
}
