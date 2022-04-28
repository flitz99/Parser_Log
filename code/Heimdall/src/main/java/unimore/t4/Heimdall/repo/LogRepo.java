package unimore.t4.Heimdall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import unimore.t4.Heimdall.model.Log;

import java.util.Optional;

public interface LogRepo extends JpaRepository<Log, Integer> {
    void deleteLogByIdLog(Integer idLog);

    Optional<Log> findLogByIdLog(Integer idLog);
}
