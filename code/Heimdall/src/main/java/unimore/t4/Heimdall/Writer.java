package unimore.t4.Heimdall;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/*
    Classe che scrive su file l'hashmap
 */
public class Writer {

    final Map<String, Object> mappa;

    //costruttore
    public Writer(Map<String, Object> mappa, String path_write) {
        this.mappa=mappa;

        BufferedWriter bf=null;

        try{
            bf= new BufferedWriter( new FileWriter(path_write,true));
            // iterate map entries

            for (Map.Entry<String, Object> entry :
                    mappa.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + ":"
                        + entry.getValue());
                // new line
                bf.newLine();
            }
            bf.write("----------------------------------------------------");
            bf.newLine();
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {

                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }

    }
}

