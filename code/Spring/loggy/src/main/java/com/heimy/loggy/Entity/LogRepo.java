package com.heimy.loggy.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo
                extends JpaRepository<LogEntity , Long> {

}
