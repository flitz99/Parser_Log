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
import unimore.t4.Heimdall.model.LogEntity;
import unimore.t4.Heimdall.repo.LogRepo;
import unimore.t4.Heimdall.service.LogService;

import java.util.ArrayList;
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
	CommandLineRunner Supder_duper_dbms_testing_pls_Test_me (LogRepo logRepo){
		return args -> {

			/////////
			//  test della logrepo.findspammerglobal()  ritorna la lista di ip e le quantita di richiesta fatte
			////////

			/*
			List<Spammer> provaspammer = new ArrayList<>();		// Array che conterrá la lista degli Spammer
			List<List<String>>repo1 = logRepo.findspammerglobal(); // test spammer
			*/

			/////////
			//  test della logrepo.findmonthday() ritorna la lista delee richieste in un determinato lasso temporale
			////////

			/*
			List<LogDMY> prova = new ArrayList<>();
			List<List<String>>repo1 = logRepo.findlogMonthday("Aug" , "31"  , "2021"); // dando i giorni giusti
				*/

			List<SpammerDMY> prova = new ArrayList<>();
			List<List<String>>repo1 = logRepo.findspammerMonthdayYearvar("Aug" , "31"  , "2021");

			for(List<String> iteratore : repo1){

				System.err.println(iteratore.toString());
				SpammerDMY u = new SpammerDMY(iteratore);				// Creo Spammer
				prova.add(u);							// Aggiungo spammer al`array
			}

			Gson gson = new Gson();
			String JsonString="[";
			for(SpammerDMY iteratore : prova){
				//System.out.println(iteratore.toString());		// test per vedere se contiene qualcosa o nullo
				JsonString+= gson.toJson(iteratore);
				JsonString+=",";
			}
			JsonString =JsonString.substring(0,JsonString.length()-1);
			JsonString+="]";
			System.out.println(JsonString);
			//return JsonString;
		};
	}
	/*@Bean
	CommandLineRunner commandLineRunner(LogRepo logrepo){
		return args -> {

			JsonReader jsonReader = new JsonReader("File_Json");
			jsonReader.readAllLogFiles();
			List<LogEntity> logEntityList= jsonReader.generateLogEntities();
			/*for (LogEntity logEntity: logEntityList){
				logrepo.save(logEntity);
			}
			// log di errore
			JsonReader jsonreadererr = new JsonReader("File_Json_err");
			jsonreadererr.readAllLogFiles();
			//List<LogEntityErr> .......    DA IMPLEMENTARE e cancellare log vuoti

		};
	}*/
	/**
	 * Main del programma il suo lavoro e semplicemente creare una istanza di HeimdallApplication e avviarala
	 * @param args argomenti di default
	 */
	public static void main(String[] args) {
		LogProcessing logProcessing = new LogProcessing("File_log", "File_output", "File_Json");
		logProcessing.logProcessing();

		//LogProcessing logprocessingerr = new LogProcessing("File_log_err", "File_output_err", "File_Json_err");
		//logprocessingerr.logProcessing();
		//Inizializzazione Applicazione Spring
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
}


