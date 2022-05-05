package unimore.t4.Heimdall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import unimore.t4.Heimdall.model.LogEntity;

import java.util.Optional;

/**
 * Interfaccia che estende la JpaRepository per poter lavorare con il database
 *
 */
public interface LogRepo
        extends JpaRepository<LogEntity, Long> {


}
