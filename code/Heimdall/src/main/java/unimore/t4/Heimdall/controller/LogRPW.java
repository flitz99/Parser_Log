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
public class LogRPW {

    private Grok grok;
    private String sourceSingleLogLine; //stringa per contenere una stringa di log
    private Match gm;
    private Map<String, Object> captureMap;
    private File logFile;
    private File logDirSource;
    private File[] allLogFiles;
    private String logDirSourcePath;
    public LogRPW(){
        GrokCompiler grokCompiler = GrokCompiler.newInstance();
        grokCompiler.registerDefaultPatterns();
        grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");
        String testLog = "93.147.139.239 - - [08/Sep/2021:06:47:32 +0000] \"GET /search/suggest.json?q=re&resources[type]=product&resources[options][unavailable_products]=last&resources[options][fields]=title,vendor,product_type,variants.title& HTTP/1.1\" 200 10578 \"https://shop.gnet.it/products/a-b-test-email?_pos=1&_psq=a&_ss=e&_v=1.0\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15\"";
        matchLog();
        makeMap();
        setLogDirSource();
        getLogFile("gnetshop.log.2");
        setSourceSingleLogLine();
    }



    private void matchLog(){
        gm = grok.match(testLog);
    }

    private void makeMap(){
        captureMap = gm.capture();
    }

    /**
     * metodo per stabilire la cartella dei log
     * PRENDERE IL METODO DI FILLO SPOSTARE CARTELLA FILE_LOGS IN HEIMDALL
     */
    private void setLogDirSource() {
        File pun = new File("");

        logDirSourcePath = pun.getParent()+File.pathSeparator+"logs"+File.pathSeparator;
        logDirSource = new File(logDirSourcePath);
        logDirSource.exists()
        allLogFiles = logDirSource.listFiles();
    }
    /**
     * Metodo che prendere il file di log su cui lavorare
     * TO-DO: cambiare i path della cartella per renderli più generale,
     * nel costruttore questo  metodo va chiamato iternado su tutti i file
     * della cartella
     * @param logName nome del log di file,
     */
    private void getLogFile(String logName){
        //ciclo per cercare il file di log dato un nome in input [da cambiare]
        for(int i = 0; i < allLogFiles.length; i++){
            if(allLogFiles[i].getName() == logName)
                logFile = allLogFiles[i];
        }
    }

    private void setSourceSingleLogLine(){

    }

}
