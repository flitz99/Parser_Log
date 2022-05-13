package unimore.t4.Heimdall.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import unimore.t4.Heimdall.Statistiche.Spammer;
import unimore.t4.Heimdall.exception.LogNotFoundException;
import unimore.t4.Heimdall.repo.LogRepo;
import unimore.t4.Heimdall.model.LogEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        return List.of(new LogEntity());
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
    /*@Bean
    CommandLineRunner testingreporunner(LogRepo logRepo){
        return args -> {

            System.out.println("provo le quarries spammer ," +
                    "che mi ritorna la lista di ip e le loro richieste in modo decrescnete in formato JSON");
            List<Spammer> provaspammer = new ArrayList<>();		// Array che conterrá la lista degli Spammer
            List<List<String>>repo1 = logRepo.findspammerobj(); // estraggo dal DB
            for(List<String> iteratore : repo1){
                Spammer u = new Spammer(iteratore);				// Creo Spammer
                provaspammer.add(u);							// Aggiungo spammer al`array
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(Spammer iteratore : provaspammer){
                //System.out.println(iteratore.toString());		// Stampa il JSON ? credo
                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";
            System.out.println(JsonString);
            //return JsonString;
        };
    }*/
    public String getspammer(){
        List<Spammer> provaspammer = new ArrayList<>();		// Array che conterrá la lista degli Spammer
        List<List<String>>repo1 = logRepo.findspammerglobal(); // estraggo dal DB
        for(List<String> iteratore : repo1){
            Spammer u = new Spammer(iteratore);				// Creo Spammer
            provaspammer.add(u);							// Aggiungo spammer al`array
        }

        Gson gson = new Gson();
        String JsonString="[";
        for(Spammer iteratore : provaspammer){
            //System.out.println(iteratore.toString());		// Stampa il JSON ? credo
            JsonString+= gson.toJson(iteratore);
            JsonString+=",";
        }
        JsonString =JsonString.substring(0,JsonString.length()-1);
        JsonString+="]";
        //System.out.println(JsonString);
        return JsonString;
    }
    /**
     * metodo statico che ritorna tutti i log
     *
     * @return oggetto lista di log
     */
    public static List<LogEntity> findAllLogs(){
        return logRepo.findAll();
    }

    /**
     * Metodo per trovare un log data la chiave primaria
     * ritorna un'eccezione in caso di log non trovato
     * @return il log recuperato
     */
    public static LogEntity findLogByIdLog(Long idLog){
        return (LogEntity) logRepo.findById(idLog).orElseThrow(
                ()->new LogNotFoundException("Log con idLog " + idLog +" non trovato"));
    }
    /*
    public void deleteLog(Integer idLog){
        logRepo.deleteLogByIdLog(idLog);
    }
    */

}
