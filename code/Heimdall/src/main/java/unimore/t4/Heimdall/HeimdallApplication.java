package unimore.t4.Heimdall;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import unimore.t4.Heimdall.PreProcessing.JsonReader;
import unimore.t4.Heimdall.PreProcessing.LogProcessing;
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.repo.LogRepo;

import unimore.t4.Heimdall.service.LogService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;
/**
 * Classe di partenza dell'applicazione
 */
@SpringBootApplication
public class HeimdallApplication {
	/**
	 * costruttore di HeimdallApplication, attualmente fa 2 cose:
	 * 1)inizializzare il  {@link LogService}
	 * 2)fare un test di parsing con logProcessing
	 */
	@Bean
	CommandLineRunner commandLineRunner(LogRepo logrepo){
		return args -> {
			logrepo.findAll();
			//JsonReader jsonReader = new JsonReader("File_Json");
			//jsonReader.readAllLogFiles();
			//List<LogEntity> logEntityList= jsonReader.generateLogEntities();
			/*for (LogEntity logEntity: logEntityList){
				logrepo.save(logEntity);
			}*/
		};
	}
	/**
	 * Main del programma il suo lavoro e semplicemente creare una istanza di HeimdallApplication e avviarala
	 * @param args argomenti di default
	 */
	public static void main(String[] args) {

		/* Create a new grokCompiler instance */
		GrokCompiler grokCompiler = GrokCompiler.newInstance();
		grokCompiler.registerDefaultPatterns();

		/* Grok pattern to compile, here httpd logs */
		String pattern_grok_err= "\\[(?<timestamp>%{DAY:day} %{MONTH:month} %{MONTHDAY} %{TIME} %{YEAR})\\]\\s+\\[:%{LOGLEVEL:loglevel}\\]\\s+\\[pid %{NUMBER:pid}]\\s+\\[client %{IP:clientip}:%{NUMBER:port}\\]\\s+\\[client %{IP:clientip2}.*?\\]\\s+ModSecurity:\\s+%{GREEDYDATA:error}\\s+\\[file\\s%{QS:path_file}\\]?(?:\\s+\\[line %{QS:line}])?(?:\\s+\\[id %{QS:id}\\])?(?:\\s+\\[msg %{QS:message}\\])?(?:\\s+\\[data %{QS:data}\\])?(?:\\s+\\[severity %{QS:severity}\\])?(?:\\s+\\[ver %{QS:ver}\\])?(?:\\s+\\[tag %{QS:tag}\\])?(?:\\s+\\[tag %{QS:tag2}\\])?(?:\\s+\\[tag %{QS:tag3}\\])?(?:\\s+\\[tag %{QS:tag4}\\])?(?:\\s+\\[tag %{QS:tag5}\\])?.*?\\[hostname %{QS:hostname}\\]\\s+\\[uri %{QS:uri}\\]\\s+\\[unique_id %{QS:unique_id}\\](?:%{GREEDYDATA:referer})";
		final Grok grok = grokCompiler.compile(pattern_grok_err);


		//                    lettura da file

		File read= new File("");
		File input = new File(read.getAbsolutePath()+File.separator+"File_log_err"+File.separator+"gnetshop.err"); //percorso di lettura file di log
		System.out.println("Percorso path lettura:"+ input.getAbsolutePath()); //stampo percorso di lettura

		File write= new File("");
		File output = new File(read.getAbsolutePath()+File.separator+"File_log_errore_write");
		if(output.exists())
			output.delete();

		BufferedWriter bw= null;
		BufferedReader br=null;
		String mylog="";
		try {
			br = new BufferedReader(new FileReader(input));
			bw= new BufferedWriter(new FileWriter(output));
			//System.out.println(br.readLine());
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("Log da analizzare: "+line);  //stampo il log letto
				Match gm = grok.match(line);  // leggo tramite grok la riga del file
				final Map<String, Object> capture = gm.capture();
				System.out.println("Log analizzato: "+capture); //stampo il log scansionato da grok
				System.out.println("------------");
				/*
				Ogni volta che viene runnato il programma viene scritto (in append) quello che legge dal file di log su output.txt
				Controllare le righe di codice! (non sovrascrive ma aggiunge ogni volta)
				 */
				bw.write(capture.toString());
				bw.newLine();
				bw.flush();
			}
			bw.flush();
			bw.close();
		}
		catch (IOException e) {
			System.out.println("Errore in lettura");
			e.printStackTrace();
		}
		//LogProcessing logProcessing = new LogProcessing("File_log", "File_output", "File_Json");
		//logProcessing.logProcessing();
		//Inizializzazione Applicazione Spring
		try {
			//SpringApplication.run(HeimdallApplication.class, args);
		}catch(BeanCreationException ex){
			Throwable realCause = unwrap(ex);
		}
	}
	public static Throwable unwrap(Throwable ex) {
		if (ex != null && BeanCreationException.class.isAssignableFrom(ex.getClass())) {
			return unwrap(ex.getCause());
		} else {
			return ex;
		}
	}
}


