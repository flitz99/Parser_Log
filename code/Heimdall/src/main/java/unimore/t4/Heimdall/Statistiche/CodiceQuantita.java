package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * classe creati come contenitore per la relativia statisica calcolata
 */
public class CodiceQuantita {

    private String codice;
    private String quantita;


    public CodiceQuantita(List<String> array) {
        this.codice = array.get(0);
        this.quantita = array.get(1);
    }


}
