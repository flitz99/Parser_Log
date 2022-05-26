package unimore.t4.Heimdall.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import unimore.t4.Heimdall.Statistiche.*;
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

    /**
     *  funzione che ritrona una lista json della classe Spammer
     * @return
     */
        public String getspammerglobal(){
            List<Spammer> provaspammer = new ArrayList<>();		// Array che conterrá la lista degli Spammer
            List<List<String>>repo1 = logRepo.findspammerglobal(); // estraggo dal DB
            for(List<String> iteratore : repo1){
                Spammer u = new Spammer(iteratore);				// Creo Spammer
                provaspammer.add(u);							// Aggiungo spammer al`array
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(Spammer iteratore : provaspammer){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }
    /**
     *  funzione che ritrona una lista json della classe LogDMY
     * @return
     */
        public String getlogall(){
            List<LogDMY> array = new ArrayList<>();
            List<List<String>>repo1 = logRepo.findlog();
            for(List<String> iteratore : repo1){
                LogDMY u = new LogDMY(iteratore);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogDMY iteratore : array){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     * funzione che fa da tramite  per logRepo.findalllogsuper()
     * @return
     */
    public String getlogallsuper(){
            List<LogComplete> array = new ArrayList<>();
            List<List<String>>repo1 = logRepo.findalllogsuper();
            for(List<String> iteratore : repo1){
                LogComplete u = new LogComplete(iteratore);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogComplete iteratore : array){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     *  funzione che fa da tramite a logrepo.findalllogsuperid(idx)
     * @param idx id da cercare
     * @return lista contente log completi in base al id
     */
    public String getlogallsuperid(String idx){
            List<LogComplete> array = new ArrayList<>();
            List<List<String>>repo1 = logRepo.findalllogsuperid(idx);
            for(List<String> iteratore : repo1){
                LogComplete u = new LogComplete(iteratore);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogComplete iteratore : array){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     *  funzione che fa da tramite a logrepo.smartstats
     * @return una lista contenente la classe CodiceQuantita
     */
    public String smartstats(){
        List<CodiceQuantita> array = new ArrayList<>();
        List<List<String>>repo1 = logRepo.smartstats();
        for(List<String> iteratore : repo1){
            CodiceQuantita u = new CodiceQuantita(iteratore);
            array.add(u);
        }

        Gson gson = new Gson();
        String JsonString="[";
        for(CodiceQuantita iteratore : array){

            JsonString+= gson.toJson(iteratore);
            JsonString+=",";
        }
        JsonString =JsonString.substring(0,JsonString.length()-1);
        JsonString+="]";

        return JsonString;
    }

    /**
     * funzione che fa da tramite a logRepo.findlogMonth
     * @param month mese da cercare
     * @param year anno da cercare
     * @return lista di LodDMY che soddisfanno i requisiti
     */
        public String getlogmonthyear(String month , String year){
            List<LogDMY> array = new ArrayList<>();
            List<List<String>>repo2 = logRepo.findlogMonth(month, year);
            for(List<String> iteratore : repo2){
                LogDMY u = new LogDMY(iteratore);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogDMY iteratore : array){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     * cerca i log in base al ip
     * @param ip_da_cercare
     * @return
     */
    public String getlogbyip(String ip_da_cercare){
            List<LogDMY> array = new ArrayList<>();
            List<List<String>>repo2 = logRepo.findlogbyip(ip_da_cercare);
            for(List<String> iteratore : repo2){
                LogDMY u = new LogDMY(iteratore);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogDMY iteratore : array){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     *  funzione che fa da tramite logRepo.findlogMonthdayip
     * @param month mese da cercare
     * @param day giorno da cercare
     * @param year anno da cercare
     * @param ip ip da cercare
     * @return
     */
        public String getlogbyipmonthday(String month ,String day, String year , String ip){
            List<LogDMY> array = new ArrayList<>();
            List<List<String>>repo2 = logRepo.findlogMonthdayip(month,day,year,ip);
            for(List<String> iteratore : repo2){
                LogDMY u = new LogDMY(iteratore);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogDMY iteratore : array){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     *  funzione che fa da tramite logRepo.findlogMonthdayip()
     * @param year anno da cercare
     * @return ritorna LogCountBytes
     */
    public String getlogcountbytes(String year ){
            List<LogCountBytes> array = new ArrayList<>();
            List<List<String>>repo2 = logRepo.findlogMonthdayip(year);
            for(List<String> iteratore : repo2){
                LogCountBytes u = new LogCountBytes(iteratore);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogCountBytes iteratore : array){

                JsonString+= gson.toJson(iteratore);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     * funzione che fa tramite logRepo.smartYMD
     * @param year anno da cercare
     * @param mont mese da cercare
     * @param day giorno da cercare
     * @return
     */
    public String smart_ymd(String year , String mont , String day){
            List<LogMinimo> array = new ArrayList<>();
            List<List<String>>repo2 = logRepo.smartYMD(year,mont,day);
            for(List<String> iterator : repo2){
                LogMinimo u = new LogMinimo(iterator);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogMinimo iterator : array){

                JsonString+= gson.toJson(iterator);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     * funzione che fa da tramite a logRepo.smartYM(year,mont)
     * @param year anno
     * @param mont mese
     * @return
     */
        public String smart_ym(String year , String mont ){
            List<LogMinimo> array = new ArrayList<>();
            List<List<String>>repo2 = logRepo.smartYM(year,mont);
            for(List<String> iterator : repo2){
                LogMinimo u = new LogMinimo(iterator);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogMinimo iterator : array){

                JsonString+= gson.toJson(iterator);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

            return JsonString;
        }

    /**
     *  funzione che fa da tramite a logRepo.findsmartlog
     * @return
     */
    public String smartalldb(){
            List<LogMinimo> array = new ArrayList<>();
            List<List<String>>repo2 = logRepo.findsmartlog();
            for(List<String> iterator : repo2){
                LogMinimo u = new LogMinimo(iterator);
                array.add(u);
            }

            Gson gson = new Gson();
            String JsonString="[";
            for(LogMinimo iterator : array){

                JsonString+= gson.toJson(iterator);
                JsonString+=",";
            }
            JsonString =JsonString.substring(0,JsonString.length()-1);
            JsonString+="]";

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
