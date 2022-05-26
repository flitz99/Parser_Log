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
    private String log_completo;
    private String sito_referente;
    private String richiesta;
    private String codice_risposta;
    private String tipo_richiesta;
    private String valutazione;

    public LogComplete( List<String> array) {
        this.id = array.get(0);
        this.giorno = array.get(1);
        this.data_completo = Crea_data_bella(array.get(4),array.get(6),array.get(1));
        this.timezone = array.get(3);
        this.mese = array.get(4);
        this.orario = array.get(5);
        this.anno = array.get(6);
        this.dispositivo = array.get(7);
        this.autenticato = array.get(8);
        this.quantita_trasmissione = array.get(9);
        this.ip_cliente = array.get(10);
        this.identificativo = array.get(11);
        this.posizione_citta = array.get(12);
        this.latitudine = array.get(13);
        this.longitudine = array.get(14);
        this.posizione_stato = array.get(15);
        this.log_completo = array.get(16);
        this.sito_referente = array.get(17);
        this.richiesta = array.get(18);
        this.codice_risposta = array.get(19);
        this.tipo_richiesta = array.get(20);
        this.valutazione = array.get(21);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getData_completo() {
        return data_completo;
    }

    public void setData_completo(String data_completo) {
        this.data_completo = data_completo;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getAutenticato() {
        return autenticato;
    }

    public void setAutenticato(String autenticato) {
        this.autenticato = autenticato;
    }

    public String getQuantita_trasmissione() {
        return quantita_trasmissione;
    }

    public void setQuantita_trasmissione(String quantita_trasmissione) {
        this.quantita_trasmissione = quantita_trasmissione;
    }

    public String getIp_cliente() {
        return ip_cliente;
    }

    public void setIp_cliente(String ip_cliente) {
        this.ip_cliente = ip_cliente;
    }

    public String getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(String identificativo) {
        this.identificativo = identificativo;
    }

    public String getPosizione_citta() {
        return posizione_citta;
    }

    public void setPosizione_citta(String posizione_citta) {
        this.posizione_citta = posizione_citta;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }

    public String getPosizione_stato() {
        return posizione_stato;
    }

    public void setPosizione_stato(String posizione_stato) {
        this.posizione_stato = posizione_stato;
    }

    public String getLog_completo() {
        return log_completo;
    }

    public void setLog_completo(String log_completo) {
        this.log_completo = log_completo;
    }

    public String getSito_referente() {
        return sito_referente;
    }

    public void setSito_referente(String sito_referente) {
        this.sito_referente = sito_referente;
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

    public String getTipo_richiesta() {
        return tipo_richiesta;
    }

    public void setTipo_richiesta(String tipo_richiesta) {
        this.tipo_richiesta = tipo_richiesta;
    }

    public String getValutazione() {
        return valutazione;
    }

    public void setValutazione(String valutazione) {
        this.valutazione = valutazione;
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
                ", log_completo='" + log_completo + '\'' +
                ", sito_referente='" + sito_referente + '\'' +
                ", richiesta='" + richiesta + '\'' +
                ", codice_risposta='" + codice_risposta + '\'' +
                ", tipo_richiesta='" + tipo_richiesta + '\'' +
                ", valutazione='" + valutazione + '\'' +
                '}';
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
