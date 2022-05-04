package com.heimy.loggy.Entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class LogEntityService {
    @GetMapping
    public List<LogEntity> getLogEntity(){
        return List.of(
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
                )
        );


    }

}
