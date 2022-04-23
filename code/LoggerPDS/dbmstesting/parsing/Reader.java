package parsing;
import java.util.Arrays;

import java.io.*;

public class Reader {
    
    public void leggidafile(){
    try{
        File prova = new File(""); 
        
        // C:\Users\Janat\Desktop\pds\2022t4\code\LoggerPDS\dbmstesting\parsing\logsexample\gnetshop.log.1
        File file = new File(prova.getAbsolutePath()+File.separator+"parsing"+File.separator+"logsexample"+File.separator+"gnetshop.log.1");
        

        FileReader fin= new FileReader(file);

        BufferedReader br =new BufferedReader(fin);
        do{
           
            String lograw = br.readLine();
            
            System.out.println(lograw);

            if(!lograw.equals(null)){

// log esempio:                  
// 144.86.173.78 - - [10/Sep/2021:21:52:51 +0000] "GET / HTTP/1.1" 200 211968 "-" "Expanse, a Palo Alto Networks company, searches across the global IPv4 space multiple times per day to identify customers&#39; presences on the Internet. If you would like to be excluded from our scans, please send IP addresses/domains to: scaninfo@paloaltonetworks.com"

            String[] logcotto = lograw.split("^([\\d.]+) (\\S+) (\\S+) \\[([\\w:\\/]+\\s[+-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+|-) \"([^\"]+)\" \"([^\"]+)\"\\W*");
            // risultato nullo
            String[] logcotto2 = lograw.split("\\s");
            // [144.86.173.78, -, -, [10/Sep/2021:21:52:51, +0000], "GET, /, HTTP/1.1", 200, 211968, "-", "Expanse,, a, Palo, Alto, Networks, company,, searches, across, the, global, IPv4, space, multiple, times, per, day, to, identify, customers&#39;, presences, on, the, Internet., If, you, would, like, to, be, excluded, from, our, scans,, please, send, IP, addresses/domains, to:, scaninfo@paloaltonetworks.com"]
            // si potrebbe iterare la lista e unire tutti i token da sinistra a destra con questa regola :
            //   se inizia con ' " '   appendi ed elimina tutto quello che é sucessivo finché non arrivi a qualcosa che finisce per ' " '
            //    qui in questo esempio qua sopra partirebbe da  TOKEN[4] = "GET,
            //      fino ad arrivare al TOKEN[6] = HTTP/1.1"  e lo unirebbe tutto in una cosa sola
            //
            //
            String[] logcotto3 = lograw.split("\\s");

            System.out.println("provo a sparare i dati");
            System.out.println("inzio con logcotto1");
            System.out.println("inzio con logcotto2");
            System.out.println(Arrays.toString(logcotto));
            System.out.println(Arrays.toString(logcotto2));

            
                                            }

        }while(br.ready());
        

        fin.close();
    }catch(IOException e) {
        System.out.println("Apertura file fallita");
        e.printStackTrace();
        System.exit(-1);
    }

}


/*


*/

}
