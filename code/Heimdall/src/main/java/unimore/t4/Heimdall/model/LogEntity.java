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
            columnDefinition = "VARCHAR(20)",
            nullable = false
    )
    private String MONTH;
    @Column(
            name = "anno" ,
            columnDefinition = "VARCHAR(20)",
            nullable = false
    )
    private String YEAR;
    @Column(
            name = "giorno" ,
            columnDefinition = "VARCHAR(20)",
            nullable = false
    )
    private String DAY;
    @Column(
            name = "dispositivo" ,
            columnDefinition = "TEXT",
            nullable = false

    )
    private String agent;
    @Column(
            name = "identificativo" ,
            columnDefinition = "TEXT"

    )
    private String ident;
    @Column(
            name = "autentificato" ,
            columnDefinition = "TEXT"

    )
    private String auth;
    @Column(
            name = "orario" ,
            columnDefinition = "VARCHAR(20)"

    )
    private String TIME;
    @Column(
            name = "Timezone" ,
            columnDefinition = "VARCHAR(20)"

    )
    private String INT;
    @Column(
            name = "sito_referente",
            columnDefinition = "TEXT"
    )
    private String referrer;
    @Column(
            name = "Codice_risposta",
            columnDefinition = "VARCHAR(20)"
    )
    private String response;
    @Column(
            name = "Qunatita_trasmissione",
            columnDefinition = "VARCHAR(20)"
    )
    private String bytes;
    @Column(
            name = "IP_cliente",
            columnDefinition = "VARCHAR(20)"
    )
    private String clientip;
    @Column(
            name = "Log_Completo",
            columnDefinition = "Text"
    )
    private String logcompleto;
    @Column(
            name = "valutazione",
            columnDefinition = "VARCHAR(20)"
    )
    private String valutazione;
    @Column(
            name = "posizione",
            columnDefinition = "Text"
    )
    private String location;
    @Column(
            name = "tipo_richiesta",
            columnDefinition = "VARCHAR(20)"
    )
    private String tipo_richiesta;
    @Column(
            name = "Data_completa",
            columnDefinition = "DATE"
    )
    private String Data_completa;  // anno-mese-giorno

    public LogEntity() {}

    public LogEntity(Long id,
                     String request,
                     String MONTH,
                     String YEAR,
                     String DAY,
                     String agent,
                     String ident,
                     String auth,
                     String TIME,
                     String INT,
                     String referrer,
                     String response,
                     String bytes,
                     String clientip,
                     String logcompleto,
                     String valutazione,
                     String location,
                     String tipo_richiesta) {
        this.id = id;
        this.request = request;
        this.MONTH = MONTH;
        this.YEAR = YEAR;
        this.DAY = DAY;
        this.agent = agent;
        this.ident = ident;
        this.auth = auth;
        this.TIME = TIME;
        this.INT = INT;
        this.referrer = referrer;
        this.response = response;
        this.bytes = bytes;
        this.clientip = clientip;
        this.logcompleto = logcompleto;
        this.valutazione = valutazione;
        this.location = location;
        this.tipo_richiesta = tipo_richiesta;
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

    public String getINT() {
        return INT;
    }

    public void setINT(String INT) {
        this.INT = INT;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
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

    public String getValutazione() {
        return valutazione;
    }

    public void setValutazione(String valutazione) {
        this.valutazione = valutazione;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTipo_richiesta() {
        return tipo_richiesta;
    }

    public void setTipo_richiesta(String tipo_richiesta) {
        this.tipo_richiesta = tipo_richiesta;
    }

    public String getData_completa() {
        return Data_completa;
    }

    public void setData_completa(String data_completa) {
        Data_completa = data_completa;
    }
}
