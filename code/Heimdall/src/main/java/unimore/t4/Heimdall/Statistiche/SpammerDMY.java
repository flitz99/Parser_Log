package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * classe creati come contenitore per la relativia statisica calcolata
 */
public class SpammerDMY {
    String ip_cliente;
    String mese;
    String anno;
    String giorno;
    String conteggio;



    public SpammerDMY(List<String> array) {
        this.ip_cliente = array.get(0);
        this.mese = array.get(1);
        this.anno = array.get(2);
        this.giorno = array.get(3);
        this.conteggio = array.get(4);
    }

}
