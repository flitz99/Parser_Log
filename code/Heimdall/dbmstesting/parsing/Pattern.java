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

        

        /* logica di estrazione del log dalla linea obbiettivo eliinare gli spazi e separare tutti gli argomenti in 9 blocchi
            soluzione facile separare per spazi
                problema : non so come evitare gli spazi dentro i apici quindi iterereo la lista basandomi su questi 2 casi

        */
        
        List<String> list = new ArrayList<String>();
        String[] patternlist = pat.pattern.split(":"); // separo il pattern nelle sue parti
        
        for(String a : patternlist ){System.out.println(a);} 
       
        // converto stringa in un array di char
        char[] chars = s.toCharArray();
        
        // devo riconoscere le virgolette per capire dove sono
        // cosi posso ricordarmi in qualche modo la posizione delle stringa e tagliare da li
        boolean virgolette = false;
        for(char a : chars ){ 
            if(a == '"' && virgolette == false){virgolette = true ; System.out.println(virgolette);}
            if(a == '"' && virgolette == true){virgolette = false ;}

        }
        
       // commando per spezzare le linee
        System.out.println( s.substring(0,15));


        

        for (String i : list){
            
            System.out.println(i);
            
    


        }
       

        return formattata;
    }
       


}
