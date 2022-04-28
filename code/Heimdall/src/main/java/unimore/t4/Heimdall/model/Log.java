package unimore.t4.Heimdall.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Log implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer idLog;

    private String Data;
    private String Time;
    private String Ident;
    private String Auth;
    private String Ipclient;
    private String Request;
    private Integer Response;
    private Integer Bytes;
    private String Agent;

    private String LogOriginal;



    public void setId(Integer idLog) {
        this.idLog = idLog;
    }

    public void setData(String data) {
        Data = data;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setIdent(String ident) {
        Ident = ident;
    }

    public void setAuth(String auth) {
        Auth = auth;
    }

    public void setIpclient(String ipclient) {
        Ipclient = ipclient;
    }

    public void setRequest(String request) {
        Request = request;
    }

    public void setResponse(Integer response) {
        Response = response;
    }

    public void setBytes(Integer bytes) {
        Bytes = bytes;
    }

    public void setAgent(String agent) {
        Agent = agent;
    }







}
