package unimore.t4.Heimdall.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/*
    Classe che scrive su file l'hashmap
 */
public class LogWriter {
    private String dirDstLogName;
    private File dirDstLog;
    private File[] allLogDstFiles;
    private Map<String, Object> mappa;

    public LogWriter(String dirDstLogName){
        dirDstLog = new File(new File("").getAbsolutePath()+File.separator
                +dirDstLogName);
        allLogDstFiles = dirDstLog.listFiles();
    }
    public  void writeLog(Map<String, Object> map) {
        this.mappa=map;
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter= new BufferedWriter( new FileWriter(allLogDstFiles[0],true));
            for (Map.Entry<String, Object> entry : mappa.entrySet()) {
                // put key and value separated by a colon
                bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
                // new line
                bufferedWriter.newLine();
            }
            bufferedWriter.write("----------------------------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {

                // always close the writer
                bufferedWriter.close();
            }
            catch (Exception e) {
            }
        }

    }
}

