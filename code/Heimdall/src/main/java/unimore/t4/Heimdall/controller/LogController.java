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




        @GetMapping("/richieste")
        public  String gettestSpammer(){
            return logService.getspammerglobal();
        }

        @GetMapping("/alldb")
        public  String getalllog(){
            return logService.getlogall();
        }

        @RequestMapping(value = "/alldb/mese/{mesex}/anno/{annox}" , method =  GET )
        @ResponseBody
        public  String getalllogMY(@PathVariable String mesex , @PathVariable String annox){
            return logService.getlogmonthyear(mesex, annox);
        }

        @RequestMapping(value = "/alldb/ip/{ipx}" , method =  GET )
        @ResponseBody
       public  String getlogbyip(@PathVariable String ipx ){
            return logService.getlogbyip(ipx);
        }

    @RequestMapping(value = "/alldb/mese/{mesex}/giorno/{dayx}/anno/{annox}/ip/{ipx}" , method =  GET )
    @ResponseBody
    public  String getalllogMY(@PathVariable String mesex , @PathVariable String dayx , @PathVariable String annox ,@PathVariable String ipx){
        return logService.getlogbyipmonthday(mesex, dayx ,annox , ipx);
    }

    @RequestMapping(value = "/alldb/bytescount/anno/{annox}" , method =  GET )
    @ResponseBody
    public  String getalllogMY(@PathVariable String annox ){
        return logService.getlogcountbytes(annox );
    }


      }

