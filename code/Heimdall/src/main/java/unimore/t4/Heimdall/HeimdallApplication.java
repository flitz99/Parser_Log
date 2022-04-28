package unimore.t4.Heimdall;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Map;

@SpringBootApplication
public class HeimdallApplication {
	public HeimdallApplication(){

	}

	public static void main(String[] args) {
		
		/* Create a new grokCompiler instance */
		GrokCompiler grokCompiler = GrokCompiler.newInstance();
		grokCompiler.registerDefaultPatterns();

		/* Grok pattern to compile, here httpd logs */
		final Grok grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");

		//                    lettura da file

		File read= new File("");
		File input = new File(read.getAbsolutePath()+File.separator+"File_log"+File.separator+"gnetshop.log.2"); //percorso di lettura file di log
		System.out.println("Percorso path lettura:"+ input.getAbsolutePath()); //stampo percorso di lettura

		BufferedReader br=null;
		String mylog="";
		try {
			//       apertura file in scrittura
			File percorso_write= new File("");
			File output = new File(percorso_write.getAbsolutePath()+File.separator+"File_output"+File.separator+"output.txt");
			System.out.println("Percorso path scrittura:"+ output.getAbsolutePath());

			br = new BufferedReader(new FileReader(input));
			//System.out.println(br.readLine());
			String line;
			while ((line = br.readLine()) != null) {
				mylog = br.readLine();
				System.out.println("Log da analizzare: "+mylog);  //stampo il log letto
				Match gm = grok.match(mylog);  // leggo tramite grok la riga del file
				final Map<String, Object> capture = gm.capture();
				System.out.println("Log analizzato: "+capture); //stampo il log scansionato da grok
				System.out.println();
				/*
				Ogni volta che viene runnato il programma viene scritto (in append) quello che legge dal file di log su output.txt
				Controllare le righe di codice! (non sovrascrive ma aggiunge ogni volta)
				 */
				Writer write= new Writer(capture,output.getAbsolutePath());   //scrittura su file della mappa ricavata da Grok
			}
		}
		catch (IOException e) {
			System.out.println("Errore in lettura");
			e.printStackTrace();
		}
		//                   fine lettura da file

		//Inizializzazione Applicazione Spring
		//SpringApplication.run(HeimdallApplication.class, args);

	}

}
