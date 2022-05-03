package unimore.t4.Heimdall.service;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

import java.io.IOException;
import java.util.Map;

/**
 *Classe che utilizza la libreria grok per fare il parsing della linea di log
 *Tiene il riferimento del file writer per scrivere il log su file txt
 */
public class LogParser {

    /**
     * oggetto che si occupa della funzione di parsing*/
    private final Grok grok;
    /**
     * oggetto di libreria per mappare il log parsato*/
    private Match gm;
    /**
     * mappa che contiene i valori del log, come Object, i tipi dei campi come
     * Sring.*/
    private Map<String, Object> captureMap;
    /**
     * riferimento alla classe logWriter per scrivere su un file l'output del 
     * processo di parsing */
    private final LogWriter logWriter;

    private final JsonWriter jsonWriter;
    /**
     * stringa che indica il patern usato per il parsing dall'oggetto grok */
    private static final String pattern = "%{COMBINEDAPACHELOG}";

    /**
     * Costruttore della classe che inzializza gli oggetti di libreria
     * @param logWriter riferimento, gia inizializzato, per scrivere su file
     * @param jsonWriter riferimento, gia inizializzato, per scrivere su file json*/
    public LogParser(LogWriter logWriter, JsonWriter jsonWriter){
        GrokCompiler grokCompiler = GrokCompiler.newInstance();
        grokCompiler.registerDefaultPatterns();
        grok = grokCompiler.compile(pattern);
        this.logWriter = logWriter;
        this.jsonWriter = jsonWriter;
    }

    /**
     * Metodo che prende una stringa ed applica su essa la logica di parsing
     * Dopodichè chiama il metodo writeLog tramite logWriter per scriverlo su
     * file
     * @param logLine linea di log grezza
     * @param name nome del file di log sorgente
     */
    public void matchLogMakeMap(String logLine, String name)
            throws IOException {
        gm = grok.match(logLine);
        captureMap = gm.capture();
        logWriter.writeLog(captureMap, name);
        jsonWriter.writeOnJson(captureMap, name);
    }
    /**
     * Getter della mappa riempita con i campi del log
     * @return captureMap mappa riempita con i campi del log
     */
    public Map getCaptureMap(){
        return captureMap;
    }
}
