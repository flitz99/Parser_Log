package unimore.t4.Heimdall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controller che prende i dati dei log, e li mostra alla view del
 * framework. Si prende carico delle chiamate rest
 */
@RestController
@RequestMapping("/log")
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
