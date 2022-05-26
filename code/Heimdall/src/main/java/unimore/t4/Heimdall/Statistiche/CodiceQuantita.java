package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * classe creata come contenitore per quarrie relativa alla quantitá relativa al codice e la quantita
 */
public class CodiceQuantita {

    private String codice;
    private String quantitá;


    public CodiceQuantita(List<String> array) {
        this.codice = array.get(0);
        this.quantitá = array.get(1);
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getQuantitá() {
        return quantitá;
    }

    public void setQuantitá(String quantitá) {
        this.quantitá = quantitá;
    }
}
