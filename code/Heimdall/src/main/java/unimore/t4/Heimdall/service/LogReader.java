package unimore.t4.Heimdall.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
    private final File[] allLogFiles;
    private final LogParser logParser;

    /**
     * Costruttore, inizializza i riferimenti alla cartella contenente i file
     * di log e all'oggetto parser
     * @param dirSrcLogName directory di input dei log
     * @param logParser oggetto parser già inizializzato
     */
    public LogReader(String dirSrcLogName, LogParser logParser){
        File dirSrcLog = new File(new File("").getAbsolutePath() + File.separator
                + dirSrcLogName);
        allLogFiles = dirSrcLog.listFiles();
        this.logParser = logParser;
    }

    /**
     * Legge i file e li salva  col metodo matchLogMakeMap(String, String)
     */
    public void readAllLogFile(){
        BufferedReader br;
        for ( File fileCur : allLogFiles) {
            try {
                br = new BufferedReader(new FileReader(fileCur));
                String sourceLogLine;
                while ((sourceLogLine = br.readLine()) != null) {
		        // viene salvato in una mappa json
                    logParser.matchLogMakeMap(sourceLogLine, fileCur.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
