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
            value = "select ip_cliente , count(*) as quantita from log_entity group by ip_cliente" ,
            nativeQuery = true
    )
        List<List<String>> findspammerobj();


}
