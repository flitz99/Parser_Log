package unimore.t4.Heimdall.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe di database per mappare gli attributi di un log
 */
@Entity
public class LogEntity implements Serializable{
    /**
     * chiave primaria dello schema, è un id che si aggiorna incrementalmente
     * in automatico
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer idLog;
    /**
     * attributo che descrive il giorno il mese e l'anno
     */
    @Column(nullable = false,updatable = false)
    private String Data;
    @Column(nullable = false,updatable = false)
    private String Time;
    /**
     * attributo che descrive l'indirizzo ip del client
     */
    @Column(nullable = false,updatable = false)
    private String Ipclient;
    /**
     * attributo che descrive il tipo di risposta ottenuta dal client
     */
    @Column(nullable = false,updatable = false)
    private Integer Response;
    /**
     * attributo che descrive il log originale senza formattazione
     */
    @Column(nullable = false,updatable = false)
    private String LogOriginal;
    /**
     * identication
     */
    private String Ident;
    /**
     * author
     */
    private String Auth;
    /**
     * attributo che descrive il tipo di richiesta del client
     */
    private String Request;
    /**
     * attributo che descrive la grandezza della risorsa ritornata
     */
    private Integer Bytes;
    /**
     * attributo che descrive lo UserAgent
     */
    private String Agent;

    //per ricreare l'oggetto log servono questi metodi
    /**
     * setter del idLog per accedere al log nel database
     * @param idLog chiave id del log
     */
    public void setId(Integer idLog) {
        this.idLog = idLog;
    }
    /**
     * setter della data del log nel database
     * @param data data del log
     */
    public void setData(String data) {
        Data = data;
    }
    /**
     * setter dell'istante del log nel database
     * @param time istante del log
     */
    public void setTime(String time) {
        Time = time;
    }
    /**
     * setter dell'identification del log nel database
     * @param ident identification del log
     */
    public void setIdent(String ident) {
        Ident = ident;
    }
    /**
     * setter dell' author del log nel database
     * @param auth author del log
     */
    public void setAuth(String auth) {
        Auth = auth;
    }
    /**
     * setter dell'indirizzo ip del client
     * @param ipclient indirizzo ip del client
     */
    public void setIpclient(String ipclient) {
        Ipclient = ipclient;
    }
    /**
     * setter della richiesta http del client
     * @param request richiesta http del client
     */
    public void setRequest(String request) {
        Request = request;
    }
    /**
     * setter della risposta http del server
     * @param response risposta http del server
     */
    public void setResponse(Integer response) {
        Response = response;
    }
    /**
     * setter della dimensione della risorsa fornita dal server
     * @param bytes dimensione della risorsa fornita dal server
     */
    public void setBytes(Integer bytes) {
        Bytes = bytes;
    }
    /**
     * setter dello user agent del client
     * @param agent  user agent del client
     */
    public void setAgent(String agent) {
        Agent = agent;
    }
}
