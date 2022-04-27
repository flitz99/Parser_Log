package com.demoproject.maven_demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer {

    final Map<String, Object> mappa;

    //costruttore
    public Writer(Map<String, Object> mappa) {
        this.mappa=mappa;

        File percorso= new File("");

        System.out.println("Percorso path:"+ percorso.getAbsolutePath());
        File output = new File(percorso.getAbsolutePath()+File.separator+"File_output"+File.separator+"output.txt");
        BufferedWriter bf=null;

        try{
            bf= new BufferedWriter( new FileWriter(output));
            // iterate map entries

            for (Map.Entry<String, Object> entry :
                    mappa.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + ":"
                        + entry.getValue());
                // new line
                bf.newLine();
            }
            bf.write("--------------------------------------------");
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
