package unimore.t4.Heimdall.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Map;

public class JsonWriter {
    private ObjectMapper mapper = new ObjectMapper();

    private Map<String, Object> mappa;
    /**
     * risultato del parsing dalla mappa al json
     */
    private String jsonResult;
    private String dirDstJsonName;
    private File dirDstJson;
    private FileOutputStream fos = null;

    public JsonWriter(String dirDstJsonName){
        dirDstJson = new File(new File("").getAbsolutePath()+File.separator
        +dirDstJsonName);
        if(!dirDstJson.mkdir())
            System.out.println("Cartella non creata");
    }

    public void writeOnJson(Map<String, Object> captureMap, String name) throws IOException {
        File currentOutputLog = new File(dirDstJson.getAbsolutePath()+
                File.separator+name+".json");
        try {
            fos = new FileOutputStream(currentOutputLog, true);
            mapper.writeValue(fos,captureMap);
            fos.write('\n');
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}