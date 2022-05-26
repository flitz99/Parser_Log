package unimore.t4.Heimdall.service;

import unimore.t4.Heimdall.geolite.HelloGeoIP2;
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.model.LogError;

import java.util.ArrayList;
import java.util.List;

public class AllLogListsErr {

    private ArrayList<LogEntityErrJson> logEntityJsonErrArrayList = null;

    private ArrayList<LogError> logErrors = null;

    public AllLogListsErr() {
        logEntityJsonErrArrayList = new ArrayList<>();
    }

    public ArrayList<LogEntityErrJson> getLogEntityJsonErrArrayList() {
        return logEntityJsonErrArrayList;
    }

    public ArrayList<LogError> getLogErrors() {
        return logErrors;
    }

    public void add(LogEntityErrJson logEntityErrJson) {
        logEntityJsonErrArrayList.add(logEntityErrJson);
    }

    public void printAllElements(){
        for (LogEntityErrJson leej: logEntityJsonErrArrayList) {
            System.out.println(leej.toString());
        }
    }

    public LogError fromLogErrorJsontoLogError(LogEntityErrJson logEntityErrJson){
        LogError logError = new LogError();
        logError.setReferer(logEntityErrJson.getReferer());
        logError.setClientIP_Port(logEntityErrJson.getClientip()+":"+logEntityErrJson.getPort());
        logError.setData(logEntityErrJson.getData());
        logError.setLine(logEntityErrJson.getLine());
        logError.setPID(logEntityErrJson.getPid());
        logError.setError(logEntityErrJson.getError());
        logError.setHostname(logEntityErrJson.getHostname());
        logError.setYEAR(logEntityErrJson.getYEAR());
        logError.setClientIP(logEntityErrJson.getClientip2());
        logError.setID(logEntityErrJson.getId());
        logError.setTag1(logEntityErrJson.getTag());
        logError.setDAY(logEntityErrJson.getDay());
        logError.setSeverity(logEntityErrJson.getSeverity());
        logError.setVer(logEntityErrJson.getVer());
        logError.setUnique_ID(logEntityErrJson.getUnique_id());
        logError.setTIME(logEntityErrJson.getTIME());
        logError.setMessage(logEntityErrJson.getMessage());
        logError.setTag4(logEntityErrJson.getTag4());
        logError.setTag5(logEntityErrJson.getTag5());
        logError.setUrl(logEntityErrJson.getUri());
        logError.setPath_File(logEntityErrJson.getPath_file());
        logError.setTag2(logEntityErrJson.getTag2());
        logError.setTag3(logEntityErrJson.getTag3());
        logError.setMONTH(logEntityErrJson.getMonth());
        logError.setLOGLEVEL(logEntityErrJson.getLoglevel());
        logError.setMONTHDAY(logEntityErrJson.getMONTHDAY());

        return logError;
    }


    public ArrayList<LogError> fromLogErrorJsonArrayListToLogErrors(){
        logErrors = new ArrayList<>();
        for(int i=0; i < logEntityJsonErrArrayList.size(); i++){
            logErrors.add(fromLogErrorJsontoLogError(logEntityJsonErrArrayList.get(i)));
        }
        return logErrors;
    }


    public String Tipo_di_richiesta(String testo){
        if( testo.contains("GET")){ return "GET";}
        if( testo.contains("POST")){ return "POST";}
        if( testo.contains("HEAD")){ return "HEAD";}
        if( testo.contains("PUT")){ return "PUT";}
        if( testo.contains("OPTIONS")){ return "OPTIONS";}
        if( testo.contains("TRACE")){ return "TRACE";}
        if( testo.contains("CONNECT")){ return "CONNECT";}
        if( testo.contains("DELETE")){ return "DELETE";}
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
