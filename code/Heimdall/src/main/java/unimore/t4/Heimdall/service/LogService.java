package unimore.t4.Heimdall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unimore.t4.Heimdall.exception.LogNotFoundException;
import unimore.t4.Heimdall.model.Log;
import unimore.t4.Heimdall.repo.LogRepo;

import java.util.List;
/**
 *Classe di servizio che serve per inizializzare i tre componenti principali
 *che fanno da  macro contenitori alle funzioni che andremmo usare. Affianca la
 *classe LogController e svolge la logica per essa.
 */
@Service
public class LogService {
    /**
     * riferimento all'interfaccia per chiamare metodi di servizio */
    @Autowired
    private static LogRepo logRepo;
    /**
     * riferimento alla classe logReader */
    private LogReader logReader;
    /**
     * riferimento alla classe logParser */
    private LogParser logParser;
     /**
     * riferimento alla classe logWriter */
    private LogWriter logWriter;

    /**
     * il writer su file il contenuto parsato
     * il parser prende una linea di log non formattato e applica il processo di parsing
     * il reader legge i file e chiama il parser
     * @param dirSrcLogName stringa contenente la directory dei log files.
     * @param dirDstLogName  Stringa contenente le directory finale dei log files
     */
    public LogService(String dirSrcLogName, String dirDstLogName){
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

    /*
    I seguenti quattro metodi sono operazioni che fanno comunicare il backend
    con il database tramite l'interfaccia LogRepo. Devono rimanere in questa classe
    Gli altri metodi (log processing...) e le altre tre classi possono essere separate
    e messe in un altro package che rappresenta la core logic.
    Le operazioni di log processing vanno comunque eseguite per prime.
    Si può mettere qui un oggeto di tipo LogProcessing, su quale viene chiamato il
    metodo di avvio del preprocessing dei file di log
     */
    public Log addLog(Log log){
        log.setId(001);
        return logRepo.save(log);
    }
    /**
     * metodo statico che ritorna tutti i log
     * @return oggetto lista di log */
    public static List<Log> findAllLogs(){
        return logRepo.findAll();
    }

    /**
     * Metodo per trovare un log data la chiave primaria
     * ritorna un'eccezione in caso di log non trovato
     * @return il log recuperato
     */
    public static Log findLogByIdLog(Integer idLog){
        return logRepo.findLogByIdLog(idLog).orElseThrow(
                ()->new LogNotFoundException("Log con idLog " + idLog +" non trovato"));
    }
    /*
    public void deleteLog(Integer idLog){
        logRepo.deleteLogByIdLog(idLog);
    }
    */
}
