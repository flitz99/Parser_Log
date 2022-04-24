package LoggerPDS;

import java.util.regex.Pattern;

public class parser {

    private String[] st =  new String[3]  ;
    // array di stringhe in cui immagazzinare i dati cercati in ogni nuova stringa: 1 ip 2 date 3 url

    //costruttore
    public parser(String Line ){
    }

    /**
     * Metodo per analizzare una stringa, prende in entrata la linea da analizzare crea 3 pattern ip,date,url li cerca e
     * liscrive dentro ad un array, il metodo successivamente ritorno l'array di stringhe.
     * @param lineDaCercare
     * @return
     */
    public String[] cercatore (String lineDaCercare ){
        // Bisogna creare i giusti pattern da cercare

       for(int i = 0 ; i<3 ; i++){
           Pattern patternIp = Pattern.compile("//([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])$") ;
           st[0] = String.valueOf(patternIp.split(lineDaCercare));
           Pattern patternDate = Pattern.compile("(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d") ;
           st[1] = String.valueOf(patternDate.split(lineDaCercare));
           Pattern patternUrl = Pattern.compile("http\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(/\\S*)?") ;
           st[1] = String.valueOf(patternUrl.split(lineDaCercare));

        }
       // se si volesse potremmo implementare già qua la scrittura su file con append creando un altro metodo.
        return st ;
    }

    public void Scrittura (){
        for (int i = 0 ; i <3 ; i++){
           System.out.println(this.st[i]) ; // modificare eventualmente in scrittura su file con output stream 
        }
    }


}
