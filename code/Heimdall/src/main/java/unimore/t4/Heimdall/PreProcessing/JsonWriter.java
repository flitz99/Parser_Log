package unimore.t4.Heimdall.PreProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Map;

public class JsonWriter {
    private final ObjectMapper mapper = new ObjectMapper();
    private File dirDstJson;

    public JsonWriter(String dirDstJsonName){
        if(dirDstJsonName.equals("File_Json")){
            dirDstJson = new File(new File("").getAbsolutePath()+File.separator
            +dirDstJsonName);
            dirDstJson.mkdir();}
        else{
            System.err.println("Invalid directories names, " +
                    "must be: File_Json");
        }
    }

    public void writeOnJson(Map<String, Object> captureMap, String name) {
        File currentOutputLog = new File(dirDstJson.getAbsolutePath()+
                File.separator+name+".json");
        BufferedWriter bw;
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