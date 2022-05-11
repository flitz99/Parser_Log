package unimore.t4.Heimdall.PreProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Map;

public class JsonWriter {
    private final ObjectMapper mapper = new ObjectMapper();
    private static File dirDstJson;
    private BufferedWriter bw;

    public JsonWriter(String dirDstJsonName) {
        if (dirDstJsonName.equals("File_Json")) {
            dirDstJson = new File(new File("").getAbsolutePath() + File.separator
                    + dirDstJsonName);
            dirDstJson.mkdir();
        }
        if (dirDstJsonName.equals("File_Json_err")) {
            dirDstJson = new File(new File("").getAbsolutePath() + File.separator
                    + dirDstJsonName);
            dirDstJson.mkdir();
        }

    }

    public void writeOnJson(Map<String, Object> captureMap, String name) {
        File currentOutputLog = new File(dirDstJson.getAbsolutePath()+
                File.separator+name+".json");
        try {
            bw = new BufferedWriter( new FileWriter(currentOutputLog,true));
            mapper.writeValue(bw,captureMap);//questa write fa chiudere lo stream
            bw = new BufferedWriter( new FileWriter(currentOutputLog,true));
            bw.write(",");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public static void addOpeningParenthesis(String name) throws IOException {
        File currentOutputLog = new File(dirDstJson.getAbsolutePath()+
                File.separator+name+".json");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(currentOutputLog));
        bufferedWriter.write("[");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void addClosingParenthesis(String name) throws IOException {
        File currentOutputLog = new File(dirDstJson.getAbsolutePath()+
                File.separator+name+".json");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(currentOutputLog,true));
        bufferedWriter.write("]");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}