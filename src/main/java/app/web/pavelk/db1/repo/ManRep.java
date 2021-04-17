package app.web.pavelk.db1.repo;

import app.web.pavelk.db1.model.Man;
import app.web.pavelk.db1.model.Woman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManRep  extends JpaRepository<Man, Long> {

}
