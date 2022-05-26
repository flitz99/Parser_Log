package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * Claase creata per contare le quantita richieste fatte da un singolo ip in tutto al database
 */
public class Spammer {

    private String ip;
    private String count;

    public Spammer(String ip, String count) {
        this.ip = ip;
        this.count = count;
    }

    public Spammer(List<String> entrata){
        this.ip = entrata.get(0);
        this.count = entrata.get(1);

    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Spammer{" +
                "ip='" + ip + '\'' +
                ", count=" + count +
                "},";
    }
}
