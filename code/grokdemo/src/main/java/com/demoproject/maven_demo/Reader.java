package com.demoproject.maven_demo;

import java.io.*;
import java.util.Map;

/**
 * classe per leggere il file di log riga per riga che a sua volta vengono mandate
 * al logger per essere riformattate
 */
public class Reader<line> {

    public String Pathdelfile ;
    // costruttore
    public Reader( String path) throws IOException {
        this.Pathdelfile = path ;
    }
// https://www.delftstack.com/it/howto/java/how-to-read-a-large-text-file-line-by-line-in-java/
    /**
     * Metodo per la lettura delle righe di un file log da chiamare ogni volta in output registra la stringa letta.
     * Prende una stringa indicante il path del file in ingresso.
     * In output ha la stringa letta.
     */
    public void ReaderLine() throws IOException {
        String file = this.Pathdelfile;
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                //ora inseriamo il parser per analizzare la riga
                parser parser = new parser();
                Map<String, Object> mappa =  parser.cercatoreGrok(line);
                // a questo punto il parser con grok ha analizzato la riga e prodotto una hashmap
                // non rimane che mettere il writer che prende in ingresso la mappa e la scrive riformattandola
                Writer writer = new Writer(mappa) ;
                // Dobbiamo decidere come scrivere gli elementi nella mappa in che sequenza e ordine


                /**
                 * chiamo a questo punto le classi e i metodo per eseguire analisis della stringa
                 *  LA STRINGA DA ANALIZZARE è : line --> sulla quale si dovrà fare il parsing.
                 */
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}