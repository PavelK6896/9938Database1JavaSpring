package app.web.pavelk.db1.repo;

import app.web.pavelk.db1.model.Woman;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WomanRep extends JpaRepository<Woman, Long> {

    @EntityGraph(value = "eg1", type = EntityGraph.EntityGraphType.FETCH)
    @Query("select w from Woman w")
    List<Woman> findAllE();


}
