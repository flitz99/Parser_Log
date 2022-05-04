package unimore.t4.Heimdall.PreProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Map;

public class JsonWriter {
    private final ObjectMapper mapper = new ObjectMapper();
    private final File dirDstJson;

    public JsonWriter(String dirDstJsonName){
        dirDstJson = new File(new File("").getAbsolutePath()+File.separator
        +dirDstJsonName);
        dirDstJson.mkdir();
    }

    public void writeOnJson(Map<String, Object> captureMap, String name) {
        File currentOutputLog = new File(dirDstJson.getAbsolutePath()+
                File.separator+name+".json");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter( new FileWriter(currentOutputLog,true));
            mapper.writeValue(bw,captureMap);//questa write fa chiudere lo stream
            bw = new BufferedWriter( new FileWriter(currentOutputLog,true));
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}