package unimore.t4.Heimdall.model;

import javax.persistence.*;

@Entity
public class LogEntity {

    @Id
    @SequenceGenerator(
            name = "log_sequence",
            sequenceName = "log_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "log_sequence"

    )
    private Long id;
    @Column(
            name = "Richiesta" ,
            columnDefinition = "Text",
            nullable = false
    )
    private String request;
    @Column(
            name = "Mese" ,
            columnDefinition = "VARCHAR(5)",
            nullable = false
    )
    private String MONTH;
    @Column(
            name = "anno" ,
            columnDefinition = "VARCHAR(5)",
            nullable = false
    )
    private String YEAR;
    private String DAY;
    private String agent;
    private String ident;
    private String auth;
    private String TIME;
    private String Timezone;   //INT
    private String referrer;
    private int response;
    private int bytes;
    private String clientip;
    private String logcompleto;


    public LogEntity() {
    }

    public LogEntity(
                     String request,
                     String MONTH,
                     String YEAR,
                     String DAY,
                     String agent,
                     String ident,
                     String auth,
                     String TIME,
                     String timezone,
                     String referrer,
                     int response,
                     int bytes,
                     String clientip,
                     String logcompleto) {

        this.request = request;
        this.MONTH = MONTH;
        this.YEAR = YEAR;
        this.DAY = DAY;
        this.agent = agent;
        this.ident = ident;
        this.auth = auth;
        this.TIME = TIME;
        this.Timezone = timezone;
        this.referrer = referrer;
        this.response = response;
        this.bytes = bytes;
        this.clientip = clientip;
        this.logcompleto = logcompleto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMONTH() {
        return MONTH;
    }

    public void setMONTH(String MONTH) {
        this.MONTH = MONTH;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getDAY() {
        return DAY;
    }

    public void setDAY(String DAY) {
        this.DAY = DAY;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getTimezone() {
        return Timezone;
    }

    public void setTimezone(String timezone) {
        Timezone = timezone;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public String getLogcompleto() {
        return logcompleto;
    }

    public void setLogcompleto(String logcompleto) {
        this.logcompleto = logcompleto;
    }





}
