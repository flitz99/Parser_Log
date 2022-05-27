package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * classe creati come contenitore per la relativia statisica calcolata
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


    @Override
    public String toString() {
        return "logCountBytes{" +
                "mese='" + mese + '\'' +
                ", num_transizioni='" + num_transizioni + '\'' +
                ", num_bytes='" + num_bytes + '\'' +
                '}';
    }

}
