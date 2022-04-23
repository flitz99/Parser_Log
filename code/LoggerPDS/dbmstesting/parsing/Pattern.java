package parsing;
import java.util.*; // import everything including List and ArrayList
public class Pattern {
    /*
    classe pensata per il futuro immaginatevi che qui poi dire in che ordine sono i dati cosi 
    in una possibile funzione 
    */
    private String pattern;

    public Pattern(String p) {

        this.pattern = p; 

    }

    
    public void setpattern( String nuovopattern){ this.pattern = nuovopattern ; }
    public void getpattern( String nuovopattern){ this.pattern = nuovopattern ; }

    /**
     * funzione che prende in ingresso 2 variabili
     * @param s  stringa appena estratta
     * @param pat il pattern de server di apache 
     * @return stringa formatata pronta al classaggio
     */
    public String spattern(String s , Pattern pat){
        String formattata = "sad";

        String[] decomposer = pat.pattern.split(":");

        /* logica di estrazione del log dalla linea obbiettivo eliinare gli spazi e separare tutti gli argomenti in 9 blocchi
            soluzione facile separare per spazi
                problema : non so come evitare gli spazi dentro i apici quindi iterereo la lista basandomi su questi 2 casi

        */
        
        List<String> list = new ArrayList<String>();
        

       
        // convert string to `char[]` array
        char[] chars = s.toCharArray();
        
 
        // IN-SVILUPPO NON ANCORA TESTATO
        // praticamente itero la stringa e separo tutte le cose 
        // esculdendo spazi e tenendo conto che tra 2 apici " ci possono essere tanti spazi"
        int rosso = 0;
        boolean trovato = true ; 
        for (int blu = 0 ; blu < chars.length; ++blu) {
            if (chars[blu]==' '){ 
                list.add(s.substring(rosso,blu-1));
                rosso = blu + 1; // sposto il cursore rosso in avanti 
            }

            if( chars[blu]=='"' && trovato == true ){
                trovato = false;
             }

             if( chars[blu]=='"' && trovato == false){ 
                trovato = true;
                list.add(s.substring(rosso,blu-1));
             }

        }
        

        for (String i : decomposer){

            switch(i) {
                case "1":

            }


        }
       

        return formattata;
    }
       


}
