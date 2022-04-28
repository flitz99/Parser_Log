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
    private String fileLogDstName = "output.txt";//nome del file di destinazione che contiene i log parsati
    private File dirDstLog, fileDstLog;
    private Map<String, Object> mappa;

    /**
     * Metodo costruttore della classe LogWriter che prende come inpuy
     * @param dirDstLogName nome cartella contenente i file dei log parsati
     */
    public LogWriter(String dirDstLogName){
        dirDstLog = new File(new File("").getAbsolutePath()+File.separator
                +dirDstLogName);
        fileDstLog = new File(dirDstLog.getAbsolutePath()+File.separator+fileLogDstName);
    }

    /**
     * metodo che inizializza il file su cui scrivere i log, l'idea è che ogni file di log originale
     * corrisponde ad un file di log di destinazione (parsato)
     * @param idxSrcLogFile indice per sapere a quale file di log è arrivato il processo di lettura e scrittura
     * @return il file su cui scrivere tutte le linee di log parsate di un singolo file di log
     */
   // private File generateLogDstFile(int idxSrcLogFile){
     //   File currentDstLogFile = (allLogDstFiles[idxSrcLogFile] = new File()
    //}
    /**
     * Funzione writelog di demo
     * @param map
     */
    public  void writeLog(Map<String, Object> map) {
        this.mappa=map;
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter= new BufferedWriter( new FileWriter(fileDstLog,true));
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

