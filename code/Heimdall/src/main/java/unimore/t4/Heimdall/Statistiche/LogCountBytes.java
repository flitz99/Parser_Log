package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * Classe creata per contenere la quarries di quanti byte sono stati sambianti in un determinato mese
 */
public class LogCountBytes {

   private String mese;

    private String num_transizioni;

    private String num_bytes;

    public LogCountBytes(List<String> array) {
        this.mese = array.get(0);
        this.num_bytes =  array.get(1);
        this.num_transizioni=  array.get(2);
    }

    public LogCountBytes(String mese, String num_transizioni, String num_bytes) {
        this.mese = mese;
        this.num_transizioni = num_transizioni;
        this.num_bytes = num_bytes;
    }

    @Override
    public String toString() {
        return "logCountBytes{" +
                "mese='" + mese + '\'' +
                ", num_transizioni='" + num_transizioni + '\'' +
                ", num_bytes='" + num_bytes + '\'' +
                '}';
    }

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public String getNum_transizioni() {
        return num_transizioni;
    }

    public void setNum_transizioni(String num_transizioni) {
        this.num_transizioni = num_transizioni;
    }

    public String getNum_bytes() {
        return num_bytes;
    }

    public void setNum_bytes(String num_bytes) {
        this.num_bytes = num_bytes;
    }
}
