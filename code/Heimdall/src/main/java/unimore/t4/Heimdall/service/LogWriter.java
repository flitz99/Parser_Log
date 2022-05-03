package unimore.t4.Heimdall.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Classe che scrive su file l'hashmap
 */
public class LogWriter {
    /**
     * File che rappresenta la cartella di destinazione dei file di log */
    private final File dirDstLog;

    /**
     * Metodo costruttore della classe LogWriter
     * @param dirDstLogName nome cartella contenente i file dei log parsati
     */
    public LogWriter(String dirDstLogName){
        dirDstLog = new File(new File("").getAbsolutePath()+File.separator
                +dirDstLogName);
        dirDstLog.mkdir();
    }

    /**
     * Metodo per scrivere sul file i valori contenuti nella mappa
     * @param map mappa con i valori del log parsato
     * @param name nome del file di log sorgente, che è uguale a quello finale
     */
    public  void writeLog(Map<String, Object> map, String name) {
        File currentOutputLog = new File(dirDstLog.getAbsolutePath()+File.separator+name);
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter= new BufferedWriter( new FileWriter(currentOutputLog,true));
            for (Map.Entry<String, Object> entry : map.entrySet()) {
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
