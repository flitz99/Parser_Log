package unimore.t4.Heimdall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unimore.t4.Heimdall.exception.LogNotFoundException;
import unimore.t4.Heimdall.model.Log;
import unimore.t4.Heimdall.repo.LogRepo;

import java.util.List;

    /**
     *    funzione futra per il database
     */
    @Service
    public class LogController {
        private final LogRepo logRepo;

        @Autowired
        public LogController(LogRepo logRepo) {
            this.logRepo = logRepo;
        }

        public Log addLog(Log log){
            log.setId(001);
            return logRepo.save(log);
        }

        public List<Log> findAllLogs(){
            return logRepo.findAll();
        }

        public Log findLogByIdLog(Integer idLog){
            return logRepo.findLogByIdLog(idLog).orElseThrow(
                    ()->new LogNotFoundException("Log con idLog " + idLog +" non trovato"));
        }
        public void deleteLog(Integer idLog){
            logRepo.deleteLogByIdLog(idLog);
        }
}

