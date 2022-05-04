package unimore.t4.Heimdall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.repo.LogRepo;
import unimore.t4.Heimdall.service.LogService;

/**
 * Classe di partenza dell'applicazione
 */
@SpringBootApplication
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
		service = new LogService("File_log", "File_output", "File_Json");
		startLogProcessing();


	}
	CommandLineRunner commandLineRunner(LogRepo logrepo){
		return args -> {
			LogEntity prova =
					new LogEntity(
							"prova richiesta" ,
							"maggio" ,
							"anno",
							"04",
							"agente prova",
							"ident prova",
							"auth prova",
							"time prova",
							"+0001",
							"referrer prova",
							123 ,
							12 ,
							"123.123.123.123",
							"questa e una prova di log completo"
							);

			logrepo.save(prova);
		};
	}
	/**
	 * Main del programma il suo lavoro e semplicemente creare una istanza di HeimdallApplication e avviarala
	 * @param args argomenti di default
	 */
	public static void main(String[] args) {
		HeimdallApplication hA = new HeimdallApplication();
		//Inizializzazione Applicazione Spring
		SpringApplication.run(HeimdallApplication.class, args);
	}
	@Bean
	public void startLogProcessing(){
		service.logProcessing();
	}
}


