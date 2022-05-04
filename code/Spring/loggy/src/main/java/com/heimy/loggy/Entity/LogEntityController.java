package com.heimy.loggy.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class LogEntityController {

    private final LogEntityService logEntityService;

    @Autowired
    public LogEntityController(LogEntityService logEntityService) {
        this.logEntityService = logEntityService;
    }

    @GetMapping
    public List<LogEntity> getLogEntity(){
        return logEntityService.getLogEntity();


    }
}
