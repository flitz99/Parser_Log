package unimore.t4.Heimdall.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;

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


