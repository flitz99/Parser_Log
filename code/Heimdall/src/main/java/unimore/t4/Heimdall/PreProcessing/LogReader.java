package unimore.t4.Heimdall.PreProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Classe che legge i file di log
 */
public class LogReader {
    private File[] allLogFiles = null;
    private LogParser logParser;
    /**
     * Costruttore, inizializza i riferimenti alla cartella contenente i file
     * di log e all'oggetto parser
     * @param dirSrcLogName directory di input dei log
     * @param logParser oggetto parser già inizializzato
     */
    public LogReader(String dirSrcLogName,LogParser logParser){
        if(dirSrcLogName.equals("File_log") && logParser != null){
            File pun = new File("");
            String pathFileLog = pun.getAbsolutePath()+File.separator+"src"+File.separator+"main"+File.separator+"java"+
                    File.separator+"unimore"+File.separator+"t4"+File.separator+"Heimdall"+File.separator+dirSrcLogName;

            System.out.println("percorso assoluto: "+pun.getAbsolutePath()+ " nome cartella log: "+dirSrcLogName);
            System.out.println("percorso assoluto pathFileLog: "+pathFileLog);
            File dirSrcLog = new File(pathFileLog);
            if(dirSrcLog.exists()){
                allLogFiles = dirSrcLog.listFiles();}
            else {
                System.out.println(dirSrcLog.list());
                System.err.println("cartella File_log, non trovata");
            }
            this.logParser = logParser;}

        if(dirSrcLogName.equals("File_log_err") && logParser !=null){
            File dirSrcErrLog = new File(new File("").getAbsolutePath() +
                    File.separator+"src"+File.separator+"main"+File.separator+
                    "java"+File.separator+"unimore"+File.separator+"t4"+File.separator+
                    "Heimdall"+File.separator+dirSrcLogName);
            if(dirSrcErrLog.exists()){
                allLogFiles = dirSrcErrLog.listFiles();}
            else {
                System.out.println(dirSrcErrLog.list());
                System.err.println("cartella File_log_err, non trovata");
            }
            this.logParser = logParser;
            //allLogFiles= dirSrcErrLog.listFiles();
            this.logParser=logParser;
        }
    }

    /**
     * Legge i file e li salva  col metodo matchLogMakeMap(String, String)
     */
    public void readAllLogFile(){
        BufferedReader br;
        System.out.println("inizio lettura files...");
        for ( File fileCur : allLogFiles) {
            try {
                br = new BufferedReader(new FileReader(fileCur));
                String sourceLogLine;
                //JsonWriter.addOpeningParenthesis(fileCur.getName());
                while ((sourceLogLine = br.readLine()) != null) {
		        // viene salvato in una mappa json
                    logParser.matchLogMakeMap(sourceLogLine, fileCur.getName());
                }
                //JsonWriter.addClosingParenthesis(fileCur.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
