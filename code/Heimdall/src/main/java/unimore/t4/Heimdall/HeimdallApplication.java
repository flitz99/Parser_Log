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

import java.util.List;

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
			JsonReader jsonReader = new JsonReader("File_Json");
			jsonReader.readAllLogFiles();
			List<LogEntity> logEntityList= jsonReader.generateLogEntities();
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
		LogProcessing logProcessing = new LogProcessing("File_log", "File_output", "File_Json");
		logProcessing.logProcessing();
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


