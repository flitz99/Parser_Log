package unimore.t4.Heimdall.Statistiche;

import java.util.List;

/**
 * classe creati come contenitore per la relativia statisica calcolata
 */
public class Spammer {

    private String ip;
    private String count;


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



    @Override
    public String toString() {
        return "Spammer{" +
                "ip='" + ip + '\'' +
                ", count=" + count +
                "},";
    }
}
