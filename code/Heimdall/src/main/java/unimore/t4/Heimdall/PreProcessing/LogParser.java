package unimore.t4.Heimdall.PreProcessing;

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
    private Grok grok;
    private LogWriter logWriter;
    private JsonWriter jsonWriter;
    /**
     * stringa che indica il patern usato per il parsing dall'oggetto grok */
    private static final String pattern = "%{COMBINEDAPACHELOG}";

    /**
     * Costruttore della classe che inzializza gli oggetti di libreria
     */
    public LogParser(String dirDstLogName, String dirDstJsonName){
        if(dirDstLogName.equals("File_output") && dirDstJsonName.equals("File_Json")) {
            GrokCompiler grokCompiler = GrokCompiler.newInstance();
            grokCompiler.registerDefaultPatterns();
            grok = grokCompiler.compile(pattern);
            jsonWriter = new JsonWriter(dirDstJsonName);
            logWriter = new LogWriter(dirDstLogName);
        }
        else
            System.err.println("Invalid directories names, " +
                "must be: File_output, File_Json");
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
        Match gm = grok.match(logLine);
        Map<String, Object> captureMap = gm.capture();
       logWriter.writeLog(captureMap, name);
        jsonWriter.writeOnJson(captureMap, name);
    }
}
