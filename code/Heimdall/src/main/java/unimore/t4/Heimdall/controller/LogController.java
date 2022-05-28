package unimore.t4.Heimdall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.repo.LogRepo;
import unimore.t4.Heimdall.service.LogService;

import java.util.Collection;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
     *Classe che rappresenta il controller dell'applicazione
     */
    @RestController
    @RequestMapping("/api")
    public class LogController {

       private final LogService logService;
        @Autowired
        public LogController(LogService logService) {
            this.logService = logService;
        }

        /**
         * chiamiamo il logService che ci ritorna la lista di un log
         * @return la lista dei log, in un formato accettabile da http
        * response entity con OK dovrebbe segnalare la buona riuscita
        * dell'operazione con il codice HTTP 200
         */
        @GetMapping("/all")
       public ResponseEntity<List<LogEntity>> getAllLogs(){
            List<LogEntity> logs = LogService.findAllLogs();
            return new ResponseEntity<>(logs, HttpStatus.OK);
        }

    /**
     *  pagina web che chiama la funzione {@link LogService#smartstats()}
     * @return
     */
    @GetMapping("/all/stats")
    public  String smartstats(){
        return logService.smartstats();
    }

    /**
     * pagina web che chiama la funzione {@link LogService#getspammerglobal()}
     * @return
     */
     @GetMapping("/richieste")
     public  String gettestSpammer(){
            return logService.getspammerglobal();
        }

    /**
     * pagina web che chiama la funzione {@link LogService#getlogall()}
     * @return
     */
    @GetMapping("/alldb")
     public  String getalllog(){
            return logService.getlogall();
        }

    /**
     * pagina web che chiama la funzione {@link LogService#smartalldb()} ()}
     * @return
     */
     @GetMapping("/alldb/all")
     public  String getalllogsuper(){
        return logService.smartalldb();
    }

    /**
     * pagina web che chiama la funzione {@link LogService#getlogallsuperid(String)}
     * @param idx
     * @return
     */
    @RequestMapping(value = "/alldb/all/{idx}" , method =  GET )
    @ResponseBody
    public  String getlogsuperid(@PathVariable String idx ){
        return logService.getlogallsuperid(idx);
    }

    /**
     * pagina web che chiama la funzione {@link LogService#getlogmonthyear(String, String)}
     * @param mesex
     * @param annox
     * @return
     */
    @RequestMapping(value = "/alldb/mese/{mesex}/anno/{annox}" , method =  GET )
    @ResponseBody
    public  String getalllogMY(@PathVariable String mesex , @PathVariable String annox){
            return logService.getlogmonthyear(mesex, annox);
        }

    /**
     * pagina web che chiama la funzione {@link LogService#getlogbyip(String)}
     * @param ipx
     * @return
     */
    @RequestMapping(value = "/alldb/ip/{ipx}" , method =  GET )
    @ResponseBody
    public  String getlogbyip(@PathVariable String ipx ){
            return logService.getlogbyip(ipx);
        }

    /**
     *  pagina web che chiama la funzione {@link LogService#getlogbyipmonthday(String, String, String, String)}
     * @param mesex
     * @param dayx
     * @param annox
     * @param ipx
     * @return
     */
    @RequestMapping(value = "/alldb/mese/{mesex}/giorno/{dayx}/anno/{annox}/ip/{ipx}" , method =  GET )
    @ResponseBody
    public  String getalllogMY(@PathVariable String mesex , @PathVariable String dayx , @PathVariable String annox ,@PathVariable String ipx){
        return logService.getlogbyipmonthday(mesex, dayx ,annox , ipx);
    }

    /**
     * pagina web che chiama la funzione {@link LogService#getlogcountbytes(String)}
     * @param annox
     * @return
     */
    @RequestMapping(value = "/alldb/bytescount/anno/{annox}" , method =  GET )
    @ResponseBody
    public  String getalllogMY(@PathVariable String annox ){
        return logService.getlogcountbytes(annox );
    }

    /**
     * pagina web che chiama la funzione {@link LogService#getcontabytesmese(String, String)}
     * @param annox
     * @param mesex
     * @return
     */
    @RequestMapping(value = "/alldb/bytescount/anno/{annox}/mese/{mesex}" , method =  GET )
    @ResponseBody
    public  String getbytesmonth(@PathVariable String annox ,@PathVariable String  mesex){
        return logService.getcontabytesmese(annox , mesex );
    }

    /**
     * pagina web che chiama la funzione {@link LogService#smartalldb()}
     * @return
     */
    @RequestMapping(value = "/smart/alldb" , method =  GET )
    @ResponseBody
    public  String smartalldb( ){return logService.smartalldb();
    }


    }

