package unimore.t4.Heimdall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import unimore.t4.Heimdall.service.LogService;

@SpringBootApplication
/**
 * Classe di partenza dell'applicazione
 */
public class HeimdallApplication {

	/**
	 * variabile per far partire la logica di supporto al programma
	 */
	private LogService service;

	/**
	 * costruttore di HeimdallApplication, attualmente fa 2 cose:
	 * 1)inizializzare il  {@link LogService}
	 * 2)fare un test di parsing con logProcessing
	 */
	public HeimdallApplication(){
		service = new LogService("File_log", "File_output");
		service.logProcessing();
	}

	/**
	 * Main del programma il suo lavoro e semplicemente creare una istanza di HeimdallApplication e avviarala
	 * @param args argomenti di default
	 */
	public static void main(String[] args) {
		HeimdallApplication hA = new HeimdallApplication();
		//Inizializzazione Applicazione Spring
		//SpringApplication.run(HeimdallApplication.class, args);
	}
}


