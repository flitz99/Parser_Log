package unimore.t4.Heimdall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import unimore.t4.Heimdall.service.LogServicer;

@SpringBootApplication
public class HeimdallApplication {
	private LogServicer controller;

	/**
	 * costruttore di HeimdallApplication , attualmente fa 2 cose
	 * la prima e inizializzare il  {@link LogServicer}
	 * la seconda e fare un test di parsing con logProcessing
	 */
	public HeimdallApplication(){
		controller = new LogServicer("File_log", "File_output");
		controller.logProcessing();
	}

	/**
	 * Main del programma il suo lavoro e semplicemente creare una istanza di HeimdallApplication e avviarala
	 * @param args
	 */
	public static void main(String[] args) {
		HeimdallApplication hA = new HeimdallApplication();
		//Inizializzazione Applicazione Spring
		//SpringApplication.run(HeimdallApplication.class, args);
	}
}


