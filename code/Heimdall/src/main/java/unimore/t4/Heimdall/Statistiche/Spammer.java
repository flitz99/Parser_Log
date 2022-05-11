package unimore.t4.Heimdall.Statistiche;

public class Spammer {

    private String ip;
    private String count;

    public Spammer(String ip, String count) {
        this.ip = ip;
        this.count = count;
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
                '}';
    }
}
