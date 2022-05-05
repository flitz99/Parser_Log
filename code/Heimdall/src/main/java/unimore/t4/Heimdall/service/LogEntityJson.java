package unimore.t4.Heimdall.service;

public class LogEntityJson {
    public String request;
    public String MONTH;
    public String agent;
    public String COMMONAPACHELOG;
    public String auth;
    public String HOUR;
    public String ident;
    public String verb;
    public String TIME;
    public String INT;
    public String referrer;
    public String YEAR;
    public String response;
    public String bytes;
    public String clientip;
    public String COMBINEDAPACHELOG;
    public String MINUTE;
    public String SECOND;
    public String httpversion;
    public String rawrequest;
    public String MONTHDAY;
    public String timestamp;
    public String geo;

    public LogEntityJson(){}

    public LogEntityJson(String request, String MONTH, String agent, String COMMONAPACHELOG, String auth, String HOUR, String ident, String verb, String TIME, String INT, String referrer, String YEAR, String response, String bytes, String clientip, String COMBINEDAPACHELOG, String MINUTE, String SECOND, String httpversion, String rawrequest, String MONTHDAY, String timestamp) {
        this.request = request;
        this.MONTH = MONTH;
        this.agent = agent;
        this.COMMONAPACHELOG = COMMONAPACHELOG;
        this.auth = auth;
        this.HOUR = HOUR;
        this.ident = ident;
        this.verb = verb;
        this.TIME = TIME;
        this.INT = INT;
        this.referrer = referrer;
        this.YEAR = YEAR;
        this.response = response;
        this.bytes = bytes;
        this.clientip = clientip;
        this.COMBINEDAPACHELOG = COMBINEDAPACHELOG;
        this.MINUTE = MINUTE;
        this.SECOND = SECOND;
        this.httpversion = httpversion;
        this.rawrequest = rawrequest;
        this.MONTHDAY = MONTHDAY;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return request+"\n"+MONTH+"\n"+agent+"\n"+COMMONAPACHELOG+"\n"+auth+"\n"+HOUR+"\n"+ident+"\n"+verb+"\n"+TIME+"\n"+INT+"\n"+referrer+"\n"+YEAR+"\n"+response+"\n"+bytes+"\n"+clientip+"\n"+COMBINEDAPACHELOG+"\n"+MINUTE+"\n"+SECOND+"\n"+httpversion+"\n"+rawrequest+"\n"+MONTHDAY+"\n"+timestamp;
    }

    public String getRequest() {
        return request;
    }

    public String getMONTH() {
        return MONTH;
    }

    public String getAgent() {
        return agent;
    }

    public String getCOMMONAPACHELOG() {
        return COMMONAPACHELOG;
    }

    public String getAuth() {
        return auth;
    }

    public String getHOUR() {
        return HOUR;
    }

    public String getIdent() {
        return ident;
    }

    public String getVerb() {
        return verb;
    }

    public String getTIME() {
        return TIME;
    }

    public String getINT() {
        return INT;
    }

    public String getReferrer() {
        return referrer;
    }

    public String getYEAR() {
        return YEAR;
    }

    public String getResponse() {
        return response;
    }

    public String getBytes() {
        return bytes;
    }

    public String getClientip() {
        return clientip;
    }

    public String getCOMBINEDAPACHELOG() {
        return COMBINEDAPACHELOG;
    }

    public String getMINUTE() {
        return MINUTE;
    }

    public String getSECOND() {
        return SECOND;
    }

    public String getHttpversion() {
        return httpversion;
    }

    public String getRawrequest() {
        return rawrequest;
    }

    public String getMONTHDAY() {
        return MONTHDAY;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
