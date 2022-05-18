package unimore.t4.Heimdall.service;

import unimore.t4.Heimdall.model.LogEntity;
import java.util.ArrayList;


public class AllLogsList {
    private ArrayList<LogEntityJson> logEntityJsonArrayList = null;
    private ArrayList<LogEntity> logEntities = null;

    public AllLogsList() {
        logEntityJsonArrayList = new ArrayList<>();
    }
    public ArrayList<LogEntityJson> getLogEntityJsonArrayList() {
        return logEntityJsonArrayList;
    }

    public ArrayList<LogEntity> getLogEntities() {
        return logEntities;
    }

    public void add(LogEntityJson logEntityJson) {
        logEntityJsonArrayList.add(logEntityJson);
    }
    public void printAllElements(){
        for (LogEntityJson lej: logEntityJsonArrayList) {
            System.out.println(lej.toString());
        }
    }
    public LogEntity fromLogEntityJsontoLogEntity(LogEntityJson logEntityJson){
        LogEntity logEntity = new LogEntity();
        logEntity.setRequest(logEntityJson.getRequest());
        logEntity.setYEAR(logEntityJson.getYEAR());
        logEntity.setMONTH(logEntityJson.getMONTH());
        logEntity.setDAY(logEntityJson.getMONTHDAY());
        logEntity.setAgent(logEntityJson.getAgent());
        logEntity.setIdent(logEntityJson.getIdent());
        logEntity.setAuth(logEntityJson.getAuth());
        logEntity.setTIME(logEntityJson.getTIME());
        logEntity.setINT(logEntityJson.getINT());
        logEntity.setReferrer(logEntityJson.getReferrer());
        logEntity.setResponse(logEntityJson.getResponse());
        logEntity.setBytes(logEntityJson.getBytes());
        logEntity.setClientip(logEntityJson.getClientip());
        logEntity.setLogcompleto(logEntityJson.getCOMBINEDAPACHELOG());
        logEntity.setValutazione(null);
        logEntity.setLocation(null);
        logEntity.setTipo_richiesta(Tipo_di_richiesta(logEntityJson.getCOMBINEDAPACHELOG()));
        logEntity.setData_completa(Crea_data_bella(logEntityJson.getMONTH(),logEntityJson.getYEAR(),logEntityJson.getMONTHDAY()));


        return logEntity;
    }
    public ArrayList<LogEntity> fromLogEntityJsonArrayListToLogEntities(){
        logEntities = new ArrayList<>();
        for(int i=0; i < logEntityJsonArrayList.size(); i++){
            logEntities.add(fromLogEntityJsontoLogEntity(logEntityJsonArrayList.get(i)));
        }
        return logEntities;
    }

    public String Tipo_di_richiesta(String testo){
        if( testo.contains("GET")){ return "GET";}
        if( testo.contains("POST")){ return "POST";}
        else return "NULL";
    }

    public String Crea_data_bella(String mese , String anno , String giorno){

        switch (mese){
            case "Jan":
                return (anno+"-01-"+giorno);
            case "Feb":
                return (anno+"-02-"+giorno);
            case "Mar":
                return (anno+"-03-"+giorno);
            case "Apr":
                return (anno+"-04-"+giorno);
            case "May":
                return (anno+"-05-"+giorno);
            case "Jun":
                return (anno+"-06-"+giorno);
            case "Jul":
                return (anno+"-07-"+giorno);
            case "Aug":
                return (anno+"-08-"+giorno);
            case "Sep":
                return (anno+"-09-"+giorno);
            case "Oct":
                return (anno+"-10-"+giorno);
            case "Nov":
                return (anno+"-11-"+giorno);
            case "Dec":
                return (anno+"-12-"+giorno);
            default: return "2022-01-01";

        }


    }
}
