package unimore.t4.Heimdall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.repo.LogRepo;
import unimore.t4.Heimdall.service.LogService;

import java.util.Collection;
import java.util.List;

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

        //Metodo per cercare da richiesta http un log dato il logId
        @GetMapping("/{idLog}")
        public LogEntity findByIdLog(@PathVariable Long idLog){
            return LogService.findLogByIdLog(idLog);
        }
        /*@GetMapping
        public List<LogEntity> getLogEntity(){
            return List.of(new LogEntity());}*/
        @GetMapping
        public  String gettestSpammer(){
            return logService.getspammer();
        }
      }

