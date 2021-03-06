package unimore.t4.Heimdall.PreProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import unimore.t4.Heimdall.geolite.HelloGeoIP2;
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.model.LogError;
import unimore.t4.Heimdall.service.AllLogListsErr;
import unimore.t4.Heimdall.service.AllLogsList;
import unimore.t4.Heimdall.service.LogEntityErrJson;
import unimore.t4.Heimdall.service.LogEntityJson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * classe che serve per deserializzare un file di log,
 * ognuno inserito in una mappa e tutte contenute in un arraylist
 */
public class JsonReader {
    //prende in input il nome della cartella di logJson
    //deserializza ogni file di log
    //ogni linea del file è un oggetto json, viene letto e messo in una mappa
    //ogni mappa può essere messa in un arraylist
    private File dirSrcJson;
    private AllLogsList list;

    private AllLogListsErr listerr;
    private boolean logError;

    /**
     *
     * @param dirSrcJsonName
     */
    public JsonReader(String dirSrcJsonName) {
        if(dirSrcJsonName.equals("File_Json")) {
            dirSrcJson = new File(new File("").getAbsolutePath() + File.separator + dirSrcJsonName);
            dirSrcJson.mkdir();
            list = new AllLogsList();
            listerr=null;
            logError = false;
        }
        if (dirSrcJsonName.equals("File_Json_err")){
            dirSrcJson = new File(new File("").getAbsolutePath() + File.separator + dirSrcJsonName);
            dirSrcJson.mkdir();
            list=null;
            listerr = new AllLogListsErr();
            logError = true;
        }
    }

    public void readAllLogFiles(){
        int totLogFiles = dirSrcJson.list().length;
        File[] allJsonLogFiles = new File[totLogFiles];
        allJsonLogFiles = dirSrcJson.listFiles();
        for (File jsonLogFile: allJsonLogFiles) {
            readFromJsonFile(jsonLogFile.getName());
        }
    }
    /**
     * metodo che legge tutto un file json e ogni riga, viene letta e convertita
     * in un oggetto logEntityJson, poi inserita nell' arraylist
     */
    public void readFromJsonFile(String jsonLogFileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonLogFile = new File(dirSrcJson.getAbsolutePath() + File.separator + jsonLogFileName);
            BufferedReader br = new BufferedReader(new FileReader(jsonLogFile));
            String sourceJsonLogLine;
            while ((sourceJsonLogLine = br.readLine()) != null) {
                if(logError==true) { // se analizzo log di errore
                    LogEntityErrJson logEntityErrJson= mapper.readValue(sourceJsonLogLine,LogEntityErrJson.class);
                    listerr.add(logEntityErrJson);
                }
                else {          //se analizzo log normali
                    LogEntityJson logEntityJson = mapper.readValue(sourceJsonLogLine, LogEntityJson.class);
                    list.add(logEntityJson);
                    //System.err.println("lo stai facendo ?");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public boolean isLogError() {
        return logError;
    }

    public void setLogError(boolean logError) {
        this.logError = logError;
    }
    public List<LogEntity> generateLogEntities(){
        return list.fromLogEntityJsonArrayListToLogEntities();
    }

    public List<LogError> generateLogErrors(){
        return listerr.fromLogErrorJsonArrayListToLogErrors();
    }
}
