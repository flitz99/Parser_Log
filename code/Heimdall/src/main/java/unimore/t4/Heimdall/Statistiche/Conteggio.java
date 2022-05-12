package unimore.t4.Heimdall.Statistiche;

public class Conteggio {

    private String giorno;
    private String mese;
    private String anno;
    private String ip_cliente;
    private Integer qunatitá_richieste;

    public Conteggio(String giorno,
                     String mese,
                     String anno,
                     String ip_cliente,
                     Integer qunatitá_richieste) {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.ip_cliente = ip_cliente;
        this.qunatitá_richieste = qunatitá_richieste;
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

    public String getIp_cliente() {
        return ip_cliente;
    }

    public void setIp_cliente(String ip_cliente) {
        this.ip_cliente = ip_cliente;
    }

    public Integer getQunatitá_richieste() {
        return qunatitá_richieste;
    }

    public void setQunatitá_richieste(Integer qunatitá_richieste) {
        this.qunatitá_richieste = qunatitá_richieste;
    }

    @Override
    public String toString() {
        return "Conteggio{" +
                "giorno='" + giorno + '\'' +
                ", mese='" + mese + '\'' +
                ", anno='" + anno + '\'' +
                ", ip_cliente='" + ip_cliente + '\'' +
                ", qunatitá_richieste='" + qunatitá_richieste + '\'' +
                '}';
    }
}
