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
    private Map<String, Object> mappa;

    /**
     * Metodo costruttore della classe LogWriter che prende come inpuy
     * @param dirDstLogName nome cartella contenente i file dei log parsati
     */
    public LogWriter(String dirDstLogName){
        dirDstLog = new File(new File("").getAbsolutePath()+File.separator
                +dirDstLogName);
    }

    /**
     * Funzione writelog di demo
     * @param map
     * @param name
     */
    public  void writeLog(Map<String, Object> map, String name) {
        File currentOutputLog = new File(dirDstLog.getAbsolutePath()+File.separator+name);
        this.mappa=map;
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter= new BufferedWriter( new FileWriter(currentOutputLog,true));
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
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}