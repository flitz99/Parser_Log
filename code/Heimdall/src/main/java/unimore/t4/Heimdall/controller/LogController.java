package unimore.t4.Heimdall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unimore.t4.Heimdall.model.Log;
import unimore.t4.Heimdall.service.LogService;

import java.util.List;

    @RestController
    @RequestMapping("/log")
    /**
     *
     */
    public class LogController {
        @Autowired
        private final LogService logService;

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
        public ResponseEntity<List<Log>> getAllLogs(){
            List<Log> logs = LogService.findAllLogs();
            return new ResponseEntity<>(logs, HttpStatus.OK);
        }

        //Metodo per cercare da richiesta http un log dato il logId
        @GetMapping("/find/{idLog}")
        public ResponseEntity<Log> getLogByIdLog(@PathVariable("idLog") Integer idLog){
            Log logLine = LogService.findLogByIdLog(idLog);
            return new ResponseEntity<>(logLine, HttpStatus.OK);
        }
}

