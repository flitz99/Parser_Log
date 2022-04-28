package unimore.t4.Heimdall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import unimore.t4.Heimdall.controller.LogController;

@SpringBootApplication
public class HeimdallApplication {
	private LogController controller;

	public HeimdallApplication(){
		controller = new LogController("File_log", "File_output");
		controller.logProcessing();
	}

	public static void main(String[] args) {
		HeimdallApplication hA = new HeimdallApplication();
	}
		//Inizializzazione Applicazione Spring
		//SpringApplication.run(HeimdallApplication.class, args);
}


