package unimore.t4.Heimdall.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unimore.t4.Heimdall.Statistiche.LogDMY;
import unimore.t4.Heimdall.Statistiche.LogErrsmart;
import unimore.t4.Heimdall.repo.LogErrRepo;
import unimore.t4.Heimdall.repo.LogRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogErrService {

    private static LogErrRepo logErrRepo;
    @Autowired
    public LogErrService(LogErrRepo logErrRepo){this.logErrRepo = logErrRepo;}

    /**
     * Funzione che fa da tramite a {@link LogErrRepo#findlog()}
     * @return
     */
    public String getlogall(){
        List<LogErrsmart> array = new ArrayList<>();
        List<List<String>>repo1 = logErrRepo.findlog();
        for(List<String> iteratore : repo1){
            LogErrsmart u = new LogErrsmart(iteratore);
            array.add(u);
        }

        Gson gson = new Gson();
        String JsonString="[";
        for(LogErrsmart iteratore : array){

            JsonString+= gson.toJson(iteratore);
            JsonString+=",";
        }
        JsonString =JsonString.substring(0,JsonString.length()-1);
        JsonString+="]";

        return JsonString;
    }


}
