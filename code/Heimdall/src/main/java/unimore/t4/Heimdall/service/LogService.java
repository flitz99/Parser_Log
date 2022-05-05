package unimore.t4.Heimdall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import unimore.t4.Heimdall.exception.LogNotFoundException;
import unimore.t4.Heimdall.repo.LogRepo;
import unimore.t4.Heimdall.model.LogEntity;

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

    private static LogRepo logRepo;
    @Autowired
    public LogService(LogRepo logRepo){this.logRepo = logRepo;}

    @GetMapping
    public List<LogEntity> getLogEntity(){
        return List.of(
                new LogEntity(
                        "prova richiesta" ,
                        "maggio" ,
                        "anno",
                        "04",
                        "agente prova",
                        "ident prova",
                        "auth prova",
                        "time prova",
                        "+0001",
                        "referrer prova",
                        123 ,
                        12 ,
                        "123.123.123.123",
                        "questa e una prova di log completo"
                )
        );
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
    /*public LogEntity addLog(LogEntity log){
        log.setId(001);
        return logRepo.save(log);
    }
    */

    /**
     * metodo statico che ritorna tutti i log
     *
     * @return oggetto lista di log
     */
    /*public static List<LogEntity> findAllLogs(){
        return logRepo.findAll();
    }*/

    /**
     * Metodo per trovare un log data la chiave primaria
     * ritorna un'eccezione in caso di log non trovato
     * @return il log recuperato
     */
    /*public static LogEntity findLogByIdLog(Integer idLog){
        return logRepo.findLogByIdLog(idLog).orElseThrow(
                ()->new LogNotFoundException("Log con idLog " + idLog +" non trovato"));
    }*/
    /*
    public void deleteLog(Integer idLog){
        logRepo.deleteLogByIdLog(idLog);
    }
    */

}
