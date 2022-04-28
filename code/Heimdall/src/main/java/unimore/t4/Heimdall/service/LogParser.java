package unimore.t4.Heimdall.service;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

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

    public LogParser(LogWriter logWriter ){
        GrokCompiler grokCompiler = GrokCompiler.newInstance();
        grokCompiler.registerDefaultPatterns();
        grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");
        //grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");
        this.logWriter = logWriter;
    }

    /**
     * Metodo che prende una stringa e la
     * @param logLine
     * @param name
     */
    public void matchLogMakeMap(String logLine, String name){
        gm = grok.match(logLine);
        captureMap = gm.capture();
        logWriter.writeLog(captureMap, name);
    }

    public Map getCaptureMap(){
        return captureMap;
    }
}
