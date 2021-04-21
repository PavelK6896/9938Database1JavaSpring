package app.web.pavelk.db1.repo;

import app.web.pavelk.db1.model.Man;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManRep extends JpaRepository<Man, Long> {


    @EntityGraph(value = "eg11", type = EntityGraph.EntityGraphType.FETCH)
    @Query("select m from Man m")
    List<Man> findAllE();

    @EntityGraph(value = "eg12", type = EntityGraph.EntityGraphType.FETCH)
    @Query("select m from Man m")
    List<Man> findAllE12();


}
