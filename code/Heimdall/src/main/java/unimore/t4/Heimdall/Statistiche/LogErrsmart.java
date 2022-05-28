package unimore.t4.Heimdall.Statistiche;

import java.util.List;

public class LogErrsmart {
    // select id , pid ,  ipv4, ipv6  , giorno , mese , anno ,referer , severitá ,  messaggio , tag1 , url from log_error

    private String id;
    private String pid;
    private String ipv4;
    private String ipv6;
    private String giorno;
    private String mese;
    private String anno;
    private String referer;
    private String severita;
    private String messaggio;
    private String tag1;
    private String url;


    public LogErrsmart(List<String> array) {
        this.id = array.get(0);
        this.pid = array.get(1);
        this.ipv4 = array.get(2);
        this.ipv6 = array.get(3);
        this.giorno = array.get(4);
        this.mese = array.get(5);
        this.anno = array.get(6);
        this.referer = array.get(7);
        this.severita = array.get(8);
        this.messaggio = array.get(9);
        this.tag1 = array.get(10);
        this.url = array.get(11);


    }


}
