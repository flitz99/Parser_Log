package unimore.t4.Heimdall;

import com.google.gson.Gson;
import org.hibernate.mapping.TypeDef;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import unimore.t4.Heimdall.PreProcessing.JsonReader;
import unimore.t4.Heimdall.PreProcessing.LogProcessing;
import unimore.t4.Heimdall.Statistiche.LogDMY;
import unimore.t4.Heimdall.Statistiche.Spammer;
import unimore.t4.Heimdall.Statistiche.SpammerDMY;
import unimore.t4.Heimdall.geolite.HelloGeoIP2;
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.model.LogError;
import unimore.t4.Heimdall.repo.LogErrRepo;
import unimore.t4.Heimdall.repo.LogRepo;
import unimore.t4.Heimdall.service.LogService;

import java.util.ArrayList;
import java.util.List;

/**
 *Classe Main del programma
 */
@SpringBootApplication
public class HeimdallApplication {


	/**
	 * Funzione Che parte una volta che Spring si é avviato per inserire i log parsati in formato json nel database
	 * @param logrepo
	 * @return
	 */
	@Bean
	CommandLineRunner Salva_File_Log_Database(LogRepo logrepo){
		return args -> {



//			JsonReader jsonReader = new JsonReader("File_Json");
//			jsonReader.readAllLogFiles();
//			List<LogEntity> logEntityList= jsonReader.generateLogEntities();
//			for (LogEntity logEntity: logEntityList){
//				System.out.println(logEntity);
//				logrepo.save(logEntity);
//		}

		};
	}

	/**
	 *Funzione Che parte una volta che Spring si é avviato per inserire i log errori parsati in formato json nel database
	 * @param logErrRepo
	 * @return
	 */

	@Bean
	CommandLineRunner Salva_File_Log_Err_Database(LogErrRepo logErrRepo){
		return args -> {

/*			JsonReader jsonreadererr = new JsonReader("File_Json_err");
			jsonreadererr.readAllLogFiles();

			List<LogError> logErrorList = jsonreadererr.generateLogErrors();

			for (LogError logError : logErrorList){

				logErrRepo.save(logError);
			}*/



		};
	}
	/**
	 * Main del programma il suo lavoro e semplicemente creare una istanza di HeimdallApplication e avviarala
	 * @param args argomenti di default
	 */
	public static void main(String[] args) {

//		System.out.println("////////////////////////////////////////////////////////");
//		System.out.println("/////////////avvio processing dei file /////////////////");
//		System.out.println("////////////////////////////////////////////////////////");
//
//
//
//
//
//		LogProcessing logprocessingerr = new LogProcessing("File_log_err", "File_output_err", "File_Json_err");
//		logprocessingerr.logProcessing();
		/**
		 * Inizializzazione della applicazione Spring
		 */
		try {
			SpringApplication.run(HeimdallApplication.class, args);
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

	public void start_processing(){
//		LogProcessing logProcessing = new LogProcessing("File_log", "File_output", "File_Json");
//		logProcessing.logProcessing();
	}
}


