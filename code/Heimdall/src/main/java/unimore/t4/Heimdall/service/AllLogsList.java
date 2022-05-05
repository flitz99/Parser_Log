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
        logEntity.setMONTH(logEntityJson.getMONTH());
        logEntity.setYEAR(logEntityJson.getYEAR());
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
        return logEntity;
    }
    public ArrayList<LogEntity> fromLogEntityJsonArrayListToLogEntities(){
        logEntities = new ArrayList<>();
        for(int i=0; i < logEntityJsonArrayList.size(); i++){
            logEntities.add(fromLogEntityJsontoLogEntity(logEntityJsonArrayList.get(i)));
        }
        return logEntities;
    }
}
