package unimore.t4.Heimdall.model;

import javax.persistence.*;

@Entity
@Table(indexes = @Index(name = "log_minimo" , columnList = "id , Data_completa , orario ,   Qunatita_trasmissione , IP_cliente , Codice_risposta , tipo_richiesta "))
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
            name = "posizione_stato",
            columnDefinition = "Text"
    )
    private String location_state;
    @Column(
            name = "tipo_richiesta",
            columnDefinition = "VARCHAR(50)"
    )
    private String tipo_richiesta;
    @Column(
            name = "Data_completa",
            columnDefinition = "DATE"
    )
    private String Data_completa;  // anno-mese-giorno
    @Column(
            name = "posizione_citta",
            columnDefinition = "VARCHAR(50)"
    )
    private String location_city;
    @Column(
            name = "latitudine",
            columnDefinition = "VARCHAR(30)"
    )
    private String location_lati;
    @Column(
            name = "longitudine",
            columnDefinition = "VARCHAR(30)"
    )
    private String location_long;



    public LogEntity() {}


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

    public String getLocation_state() {
        return location_state;
    }

    public void setLocation_state(String location_state) {
        this.location_state = location_state;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_lati() {
        return location_lati;
    }

    public void setLocation_lati(String location_lati) {
        this.location_lati = location_lati;
    }

    public String getLocation_long() {
        return location_long;
    }

    public void setLocation_long(String location_long) {
        this.location_long = location_long;
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

    @Override
    public String toString() {
        return "LogEntity{" +
                "id=" + id +
                ", request='" + request + '\'' +
                ", MONTH='" + MONTH + '\'' +
                ", YEAR='" + YEAR + '\'' +
                ", DAY='" + DAY + '\'' +
                ", agent='" + agent + '\'' +
                ", ident='" + ident + '\'' +
                ", auth='" + auth + '\'' +
                ", TIME='" + TIME + '\'' +
                ", INT='" + INT + '\'' +
                ", referrer='" + referrer + '\'' +
                ", response='" + response + '\'' +
                ", bytes='" + bytes + '\'' +
                ", clientip='" + clientip + '\'' +
                ", logcompleto='" + logcompleto + '\'' +
                ", valutazione='" + valutazione + '\'' +
                ", location_state='" + location_state + '\'' +
                ", tipo_richiesta='" + tipo_richiesta + '\'' +
                ", Data_completa='" + Data_completa + '\'' +
                ", location_city='" + location_city + '\'' +
                ", location_lati='" + location_lati + '\'' +
                ", location_long='" + location_long + '\'' +
                '}';
    }
}
