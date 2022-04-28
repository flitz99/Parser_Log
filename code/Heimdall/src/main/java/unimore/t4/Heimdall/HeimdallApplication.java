package unimore.t4.Heimdall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import unimore.t4.Heimdall.controller.LogController;

@SpringBootApplication
public class HeimdallApplication {
	private LogController controller;

	/**
	 * costruttore di HeimdallApplication , attualmente fa 2 cose
	 * la prima e inizializzare il  {@link unimore.t4.Heimdall.controller.LogController}
	 * la seconda e fare un test di parsing con logProcessing
	 */
	public HeimdallApplication(){
		controller = new LogController("File_log", "File_output");
		controller.logProcessing();
	}

	/**
	 * Main del programma il suo lavoro e semplicemente creare una istanza di HeimdallApplication e avviarala
	 * @param args
	 */
	public static void main(String[] args) {
		HeimdallApplication hA = new HeimdallApplication();
	}
		//Inizializzazione Applicazione Spring
		//SpringApplication.run(HeimdallApplication.class, args);
}


