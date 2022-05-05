package com.heimy.loggy;

import com.heimy.loggy.Entity.LogEntity;
import com.heimy.loggy.Entity.LogRepo;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class LoggyApplication {



	public static void main(String[] args) {

		try {
			SpringApplication.run(LoggyApplication.class, args);
		}catch (BeanCreationException ex){
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
	@Bean
	CommandLineRunner commandLineRunner (LogRepo logRepo){
		return args -> {
			LogEntity logEntity = new LogEntity(
							10L,
					"prova richiesta" ,
					"mag" ,
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

			logRepo.save(logEntity);


		};
	}


	}


