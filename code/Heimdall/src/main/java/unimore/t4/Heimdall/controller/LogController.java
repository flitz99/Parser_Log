package unimore.t4.Heimdall.controller;

/**
 * Classe controller che prende i dati dei log, gli applica la logica e li
 * restituisce alla view
 */
public class LogController {
    LogReader logReader;
    LogParser logParser;
    LogWriter logWriter;

    public LogController(String dirSrcLogName, String dirDstLogName){
        logWriter = new LogWriter(dirDstLogName);
        logParser = new LogParser(logWriter);
        logReader = new LogReader(dirSrcLogName, logParser);

    }

    public void logProcessing(){
        logReader.readLogFile();
    }
}
