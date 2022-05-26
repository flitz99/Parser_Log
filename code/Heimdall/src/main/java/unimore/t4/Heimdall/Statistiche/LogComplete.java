package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * Classe creata per contenere nella sua interezza i log salvati nel database
 */
public class LogComplete {

    private String id;
    private String giorno;
    private String data_completo;
    private String timezone;
    private String mese;
    private String orario;
    private String anno;
    private String dispositivo;
    private String autenticato;
    private String quantita_trasmissione;
    private String ip_cliente;
    private String identificativo;
    private String posizione_citta;
    private String latitudine;
    private String longitudine;
    private String posizione_stato;
    private String sito_referente;
    private String richiesta;
    private String codice_risposta;
    private String tipo_richiesta;
    private String valutazione;



    public LogComplete(List<String> arrays ) {
        this.id = arrays.get(0);
        this.giorno =  arrays.get(1); // togli
        this.data_completo =  arrays.get(2);
        this.timezone =  arrays.get(3);
        this.mese =  arrays.get(4);    // togli
        this.orario =  arrays.get(5);
        this.anno =  arrays.get(6);  // togli
        this.dispositivo =  arrays.get(7);  // togli
        this.autenticato =  arrays.get(8);   // togli
        this.quantita_trasmissione =  arrays.get(9);
        this.ip_cliente =  arrays.get(10);
        this.identificativo =  arrays.get(11);    // togli
        this.posizione_citta =  arrays.get(12);   // togli
        this.latitudine =  arrays.get(13);    // togli
        this.longitudine =  arrays.get(14);   // togli
        this.posizione_stato = arrays.get(15);   // togli
        this.sito_referente = arrays.get(16);   // togli
        this.richiesta = arrays.get(17);
        this.codice_risposta = arrays.get(18);
        this.tipo_richiesta = arrays.get(19);
        this.valutazione = arrays.get(20);   // togli


    }

    @Override
    public String toString() {
        return "LogComplete{" +
                "id='" + id + '\'' +
                ", giorno='" + giorno + '\'' +
                ", data_completo='" + data_completo + '\'' +
                ", timezone='" + timezone + '\'' +
                ", mese='" + mese + '\'' +
                ", orario='" + orario + '\'' +
                ", anno='" + anno + '\'' +
                ", dispositivo='" + dispositivo + '\'' +
                ", autenticato='" + autenticato + '\'' +
                ", quantita_trasmissione='" + quantita_trasmissione + '\'' +
                ", ip_cliente='" + ip_cliente + '\'' +
                ", identificativo='" + identificativo + '\'' +
                ", posizione_citta='" + posizione_citta + '\'' +
                ", latitudine='" + latitudine + '\'' +
                ", longitudine='" + longitudine + '\'' +
                ", posizione_stato='" + posizione_stato + '\'' +
                ", sito_referente='" + sito_referente + '\'' +
                ", richiesta='" + richiesta + '\'' +
                ", codice_risposta='" + codice_risposta + '\'' +
                ", tipo_richiesta='" + tipo_richiesta + '\'' +
                ", valutazione='" + valutazione + '\'' +
                '}';
    }

}

