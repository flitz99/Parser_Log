package unimore.t4.Heimdall.Statistiche;

public class Spammer {

    private String ip;
    private int count;

    public Spammer(String ip, int count) {
        this.ip = ip;
        this.count = count;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
