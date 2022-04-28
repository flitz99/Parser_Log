package unimore.t4.Heimdall.service;


public class LogServicer {
    LogReader logReader;
    LogParser logParser;
    LogWriter logWriter;

    /**
     * Classe fantoccia  che serve per inizializzare i nostri 3 componenti principali che fanno da  macro contenitori
     * alle funzioni che andremmo usare , mi dispiace ma java funziona cosi
     * il writer  {@link unimore.t4.Heimdall.service.LogWriter}   scrive da qualche parte il contenuto parsato
     * il parser {@link unimore.t4.Heimdall.service.LogParser}  prende una linea di log non formattato e applica grok
     * il reader {@link unimore.t4.Heimdall.service.LogReader}    legge i file e chiama il parser
     * dopo averli creati si ferma.
     * @param dirSrcLogName stringa contenente la directory dei log files.
     * @param dirDstLogName  Stringa contenente le directory finale dei log files
     */
    public LogServicer(String dirSrcLogName, String dirDstLogName){
        logWriter = new LogWriter(dirDstLogName);
        logParser = new LogParser(logWriter);
        logReader = new LogReader(dirSrcLogName, logParser);
    }

    /**
     *  processo che fa avviare il processo di lettura, parsing, scrittura
     */
    public void logProcessing(){
        logReader.readAllLogFile();
    }
}
