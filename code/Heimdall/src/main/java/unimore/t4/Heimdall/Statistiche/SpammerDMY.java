package unimore.t4.Heimdall.Statistiche;

import java.util.List;

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

    public String getIp_cliente() {
        return ip_cliente;
    }

    public void setIp_cliente(String ip_cliente) {
        this.ip_cliente = ip_cliente;
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

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getConteggio() {
        return conteggio;
    }

    public void setConteggio(String conteggio) {
        this.conteggio = conteggio;
    }
}
