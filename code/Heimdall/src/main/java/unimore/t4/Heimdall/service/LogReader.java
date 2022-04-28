package unimore.t4.Heimdall.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
    private File dirSrcLog;
    private File[] allLogFiles;
    private LogParser logParser;

    /**
     * Metodo costruttore per la classe LogReader , fa da contenitore alla funzioni che si occuppano di leggere
     * dai file e assegnare le directory
     * @param dirSrcLogName  directory di input dei log
     * @param logParser   directory di output formattato
     */
    public LogReader(String dirSrcLogName, LogParser logParser){
        dirSrcLog = new File(new File("").getAbsolutePath()+File.separator
                +dirSrcLogName);
        allLogFiles = dirSrcLog.listFiles();
        this.logParser = logParser;
    }

    /**
     * Legge i file e li salva  col metodo {@link unimore.t4.Heimdall.service.LogParser#matchLogMakeMap(String)}
     */
    public void readLogFile(){
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(allLogFiles[3]));//provo sul file gnetshop.log.2
            String sourceLogLine;
            while((sourceLogLine = br.readLine()) != null) {
                logParser.matchLogMakeMap(sourceLogLine); // viene salvato in una mappa json
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readAllLogFile(){

        for ( File fileattuale : dirSrcLog.listFiles()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(fileattuale));//provo sul file gnetshop.log.2
                String sourceLogLine;
                while ((sourceLogLine = br.readLine()) != null) {
                    logParser.matchLogMakeMap(sourceLogLine); // viene salvato in una mappa json
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
