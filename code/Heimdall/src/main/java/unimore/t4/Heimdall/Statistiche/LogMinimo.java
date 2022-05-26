package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * Classe creata come contenitore per al quarries di un log formato ridotto
 */
public class LogMinimo {

    private String data_completa;

    private String orario;

    private String ip_cliente;

    private String tipo_richiesta;

    private String codice_risposta ;

    private String quantita_trasmissione;

    private String posizione_stato;

    private String posizione_citta;

    private String ID;

    public LogMinimo(List<String> array) {
        this.data_completa = array.get(0);
        this.orario = array.get(1);
        this.ip_cliente = array.get(2);
        this.tipo_richiesta = array.get(3);
        this.codice_risposta = array.get(4);
        this.quantita_trasmissione = array.get(5);
        this.posizione_stato = array.get(6);
        this.posizione_citta = array.get(7);
        this.ID =array.get(8);
    }

    @Override
    public String toString() {
        return "LogMinimo{" +
                "data_completa='" + data_completa + '\'' +
                ", orario='" + orario + '\'' +
                ", ip_cliente='" + ip_cliente + '\'' +
                ", tipo_richiesta='" + tipo_richiesta + '\'' +
                ", codice_risposta='" + codice_risposta + '\'' +
                ", quantita_trasmissione='" + quantita_trasmissione + '\'' +
                ", posizione_stato='" + posizione_stato + '\'' +
                ", posizione_citta='" + posizione_citta + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
