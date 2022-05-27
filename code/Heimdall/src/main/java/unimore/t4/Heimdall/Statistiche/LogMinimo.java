package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * classe creati come contenitore per la relativia statisica calcolata
 */
public class LogMinimo {

    private String id ;
    private String data_completo;

    private String orario;
    private String quantita_trasmissione;
    private String ip_cliente;
    private String richiesta;
    private String codice_risposta;
    private String tipo_richiesta;


    public LogMinimo(List<String> array) {
        this.id = array.get(0);
        this.data_completo = array.get(1);
        this.orario = array.get(2);;
        this.quantita_trasmissione = array.get(3);;
        this.ip_cliente = array.get(4);;
        this.richiesta = array.get(5);
        this.codice_risposta = array.get(6);
        this.tipo_richiesta = array.get(7);
    }

    @Override
    public String toString() {
        return "LogMinimo{" +
                "id='" + id + '\'' +
                ", data_completo='" + data_completo + '\'' +
                ", orario='" + orario + '\'' +
                ", quantita_trasmissione='" + quantita_trasmissione + '\'' +
                ", ip_cliente='" + ip_cliente + '\'' +
                ", richiesta='" + richiesta + '\'' +
                ", codice_risposta='" + codice_risposta + '\'' +
                ", tipo_richiesta='" + tipo_richiesta + '\'' +
                '}';
    }
}
