package unimore.t4.Heimdall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unimore.t4.Heimdall.model.LogEntity;

import java.util.List;
import java.util.Optional;

/**
 * Interfaccia che estende la JpaRepository per poter lavorare con il database
 */
public interface LogRepo extends JpaRepository<LogEntity, Long> {
    /**
     * metodo che implementa una query e restituisce le logEntity che la soddisfano
     * dentro una lista di lista di stringhe
     * @return
     */

    /**
     *Metodo statico che ritorna un Array di Array di stringhe contentei
     * @return
     */
    @Query(
            value = "select ip_cliente , count(*) as quantita from log_entity group by ip_cliente" ,
            nativeQuery = true
    )
    List<List<String>> findspammerobj();




}
