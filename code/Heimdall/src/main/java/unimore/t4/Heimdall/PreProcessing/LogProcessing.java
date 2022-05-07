package unimore.t4.Heimdall.PreProcessing;

import java.io.File;

public class LogProcessing {
    /**
     * riferimento alla classe logReader */
    private LogReader logReader;
    /**
     * riferimento alla classe logParser */
    private LogParser logParser;
    /**
     * riferimento alla classe logWriter */
    private LogWriter logWriter;

    private JsonWriter jsonWriter;
    /**
     * il writer su file il contenuto parsato
     * il parser prende una linea di log non formattato e applica il processo di parsing
     * il reader legge i file e chiama il parser
     * @param dirSrcLogName stringa contenente la directory dei log files.
     * @param dirDstLogName  Stringa contenente le directory finale dei log files
     */
    public LogProcessing(String dirSrcLogName, String dirDstLogName, String dirDstJsonName){
        preprocessingDirs(dirDstLogName, dirDstJsonName);
        jsonWriter = new JsonWriter(dirDstJsonName);
        logWriter = new LogWriter(dirDstLogName);
        logParser = new LogParser(logWriter, jsonWriter);
        logReader = new LogReader(dirSrcLogName, logParser);
    }
    /**
     *  processo che fa avviare il processo di lettura, parsing, scrittura
     */
    public void logProcessing(){
        logReader.readAllLogFile();
    }

    private void preprocessingDirs(String dirDstLogName, String dirDstJsonName) {
        File dirDstJson = new File(new File("").getAbsolutePath() + File.separator
                + dirDstJsonName);
        if (!dirDstJson.mkdir()) {
            boolean err = deleteDirectory(dirDstJson);
        }
        File dirDstLog = new File(new File("").getAbsolutePath() + File.separator
                + dirDstLogName);
        if (!dirDstLog.mkdir()) {
            boolean err = deleteDirectory(dirDstLog);
        }
    }
    private boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
