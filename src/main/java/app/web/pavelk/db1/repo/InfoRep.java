package app.web.pavelk.db1.repo;

import app.web.pavelk.db1.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRep extends JpaRepository<Info, Long> {
}
