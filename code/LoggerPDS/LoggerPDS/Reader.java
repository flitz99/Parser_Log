package LoggerPDS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe per leggere il file di log riga per riga che a sua volta vengono mandate
 * al logger per essere riformattate
 */
public class Reader<line> {


    // costruttore
    public Reader() throws IOException {
        System.out.println("costruisco il lettore delle righe");
    }

    /**
     * Metodo per la lettura delle righe di un file log da chiamare ogni volta in output registra la stringa letta.
     * Prende una stringa indicante il path del file in ingresso.
     * In output ha la stringa letta.
     */
    public String ReaderLine(String PATH) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(PATH));
        System.out.println("lettura riga"); // per un controlo veloce
        return reader.readLine(); // il metodo legge la linea e la ritorna subito appena viene invocato

    }

}
