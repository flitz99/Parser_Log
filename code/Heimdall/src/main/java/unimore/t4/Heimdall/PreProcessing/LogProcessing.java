package unimore.t4.Heimdall.PreProcessing;

import java.io.File;
import java.util.Objects;

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
    public LogProcessing(String dirSrcLogName, String dirDstLogName ,String dirDstJsonName ){
        if(Objects.equals(dirSrcLogName, "File_log")
                && Objects.equals(dirDstLogName, "File_output")
                && Objects.equals(dirDstJsonName, "File_Json")) {
                preprocessingDirs(dirDstLogName, dirDstJsonName);
                logParser = new LogParser(dirDstLogName, dirDstJsonName);
                logReader = new LogReader(dirSrcLogName, logParser);
        }

        if (Objects.equals(dirSrcLogName,"File_log_err")
            && Objects.equals(dirDstLogName,"File_output_err")
            && Objects.equals(dirDstJsonName,"File_Json_err")){
            preprocessingDirs(dirDstLogName,dirDstJsonName);
            logParser = new LogParser(dirDstLogName, dirDstJsonName);
            logReader= new LogReader (dirSrcLogName,logParser);
        }
    }
    /**
     *  processo che fa avviare il processo di lettura, parsing, scrittura
     */
    public void logProcessing(){
        logReader.readAllLogFile();
    }

    private void preprocessingDirs(String dirDstLogName, String dirDstJsonName) {
        if(Objects.equals(dirDstLogName, "File_output") && Objects.equals(dirDstJsonName, "File_Json")){
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
        // Controllo log di errore
        if(Objects.equals(dirDstLogName, "File_output_err") && Objects.equals(dirDstJsonName, "File_Json_err")){
            File dirDstJsonErr = new File(new File("").getAbsolutePath() + File.separator
                    + dirDstJsonName);
            if (!dirDstJsonErr.mkdir()) {
                boolean err = deleteDirectory(dirDstJsonErr);
            }
            File dirDstLogErr = new File(new File("").getAbsolutePath() + File.separator
                    + dirDstLogName);
            if (!dirDstLogErr.mkdir()) {
                boolean err = deleteDirectory(dirDstLogErr);
            }
        }
    }
    private boolean deleteDirectory(File directoryToBeDeleted) {
        boolean isDirDeleted = false;
        if (directoryToBeDeleted.exists()) {
            File[] allContents = directoryToBeDeleted.listFiles();
            if (allContents != null) {
                for (File file : allContents) {
                    deleteDirectory(file);
                }
            }
            isDirDeleted = directoryToBeDeleted.delete();
        }
        return isDirDeleted;
    }
}
