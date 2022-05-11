package unimore.t4.Heimdall.repo;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unimore.t4.Heimdall.Statistiche.Conteggio;
import unimore.t4.Heimdall.Statistiche.Spammer;
import unimore.t4.Heimdall.model.LogEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Interfaccia che estende la JpaRepository per poter lavorare con il database
 */
public interface LogRepo extends JpaRepository<LogEntity, Long> {

    @Query(
       value = "select  giorno , mese ,  anno, ip_cliente ,  count(*) as quantitá_richieste FROM log_entity group by anno , ip_cliente , mese , giorno order by quantitá_richieste Desc" ,
            nativeQuery = true


    )
    List<Conteggio> findCount();


    @Query("SELECT new unimore.t4.Heimdall.Statistiche.Spammer(ip_cliente , COUNT(ip_cliente)) FROM log_entity GROUP BY u.ip_cliente"
    )
    List<Spammer> findspammer();

}
