package unimore.t4.Heimdall.Statistiche;

import java.util.List;

public class LogDMY {

    private String giorno;
    private String mese;
    private String anno;
    private String orario;
    private String timezone;
    private String ip_cliente;
    private String autentificato;
    private String identificativo;
    private String dispositivo;
    private String stato_referente;
    private String richiesta;
    private String codice_risposta;
    private String quantita_trasmissione;


    public LogDMY(List<String> estratto) {
        this.giorno = estratto.get(0);
        this.mese =  estratto.get(1);
        this.anno = estratto.get(2);
        this.orario =  estratto.get(3);
        this.timezone =  estratto.get(4);
        this.ip_cliente =  estratto.get(5);
        this.autentificato =  estratto.get(6);
        this.identificativo = estratto.get(7);
        this.dispositivo =  estratto.get(8);
        this.stato_referente =  estratto.get(9);
        this.richiesta =  estratto.get(10);
        this.codice_risposta = estratto.get(11);
        this.quantita_trasmissione = estratto.get(12);
    }


    public LogDMY(String giorno, String mese, String anno, String orario, String timezone, String ip_cliente, String autentificato, String identificativo, String dispositivo, String stato_referente, String richiesta, String codice_risposta, String quantita_trasmissione) {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.orario = orario;
        this.timezone = timezone;
        this.ip_cliente = ip_cliente;
        this.autentificato = autentificato;
        this.identificativo = identificativo;
        this.dispositivo = dispositivo;
        this.stato_referente = stato_referente;
        this.richiesta = richiesta;
        this.codice_risposta = codice_risposta;
        this.quantita_trasmissione = quantita_trasmissione;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getIp_cliente() {
        return ip_cliente;
    }

    public void setIp_cliente(String ip_cliente) {
        this.ip_cliente = ip_cliente;
    }

    public String getAutentificato() {
        return autentificato;
    }

    public void setAutentificato(String autentificato) {
        this.autentificato = autentificato;
    }

    public String getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(String identificativo) {
        this.identificativo = identificativo;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getStato_referente() {
        return stato_referente;
    }

    public void setStato_referente(String stato_referente) {
        this.stato_referente = stato_referente;
    }

    public String getRichiesta() {
        return richiesta;
    }

    public void setRichiesta(String richiesta) {
        this.richiesta = richiesta;
    }

    public String getCodice_risposta() {
        return codice_risposta;
    }

    public void setCodice_risposta(String codice_risposta) {
        this.codice_risposta = codice_risposta;
    }

    public String getQuantita_trasmissione() {
        return quantita_trasmissione;
    }

    public void setQuantita_trasmissione(String quantita_trasmissione) {
        this.quantita_trasmissione = quantita_trasmissione;
    }

    @Override
    public String toString() {
        return "LogDMY{" +
                "giorno='" + giorno + '\'' +
                ", mese='" + mese + '\'' +
                ", anno='" + anno + '\'' +
                ", orario='" + orario + '\'' +
                ", timezone='" + timezone + '\'' +
                ", ip_cliente='" + ip_cliente + '\'' +
                ", autentificato='" + autentificato + '\'' +
                ", identificativo='" + identificativo + '\'' +
                ", dispositivo='" + dispositivo + '\'' +
                ", stato_referente='" + stato_referente + '\'' +
                ", richiesta='" + richiesta + '\'' +
                ", codice_risposta='" + codice_risposta + '\'' +
                ", quantita_trasmissione='" + quantita_trasmissione + '\'' +
                '}';
    }
}
