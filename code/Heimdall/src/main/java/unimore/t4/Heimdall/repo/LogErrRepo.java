package unimore.t4.Heimdall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import unimore.t4.Heimdall.model.LogError;


/**
 * interfaccia per salvare i LogError nel databse una volta creati
 */
public interface LogErrRepo extends JpaRepository< LogError, Long> {
}
