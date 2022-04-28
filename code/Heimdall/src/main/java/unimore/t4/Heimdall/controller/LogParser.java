package unimore.t4.Heimdall.controller;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

import java.io.File;
import java.util.Map;

/**
 * Classe di logica per leggere un file di log, parsarlo tramite grok,
 * scriverlo su file json, mappare gli oggetti del log negli attributi della classe
 */
public class LogParser {

    private Grok grok;
    private Match gm;
    private Map<String, Object> captureMap;
    private LogWriter logWriter;

    public LogParser(LogWriter logWriter){
        GrokCompiler grokCompiler = GrokCompiler.newInstance();
        grokCompiler.registerDefaultPatterns();
        grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");
        this.logWriter = logWriter;
    }

    public void matchLogMakeMap(String logLine){
        gm = grok.match(logLine);
        captureMap = gm.capture();
        logWriter.writeLog(captureMap);
    }

    public Map getCaptureMap(){
        return captureMap;
    }
}
