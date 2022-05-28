package unimore.t4.Heimdall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unimore.t4.Heimdall.model.LogError;

import java.util.List;


/**
 * interfaccia per salvare i LogError nel databse una volta creati
 */
public interface LogErrRepo extends JpaRepository< LogError, Long> {

    /**
     * Quarries che ritorna i valori   id , pid ,  ipv4, ipv6  , giorno , mese , anno ,referer , severitá ,  messaggio , tag1 , url di tutte le stringhe
     * @return
     */
    @Query( value = "select id , pid ,  ipv4, ipv6  , giorno , mese , anno ,referer , severitá ,  messaggio , tag1 , url from log_error",
            nativeQuery = true

    )List<List<String>> findlog();

}
