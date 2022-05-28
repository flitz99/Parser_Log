package unimore.t4.Heimdall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unimore.t4.Heimdall.service.LogErrService;


@RestController
@RequestMapping("/err")
public class LogErrController {

    private final LogErrService logService;
    @Autowired
    public LogErrController(LogErrService logService) {
        this.logService = logService;
    }

    /**
     * Funzione che chiama {@link LogErrService#getlogall()}
     * @return
     */
    @GetMapping("/alllogs")
    public  String getalllog(){
        return logService.getlogall();
    }


    @GetMapping("/prova")
    public  String prova(){
        return "ciao";
    }



}
