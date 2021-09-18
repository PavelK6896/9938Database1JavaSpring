package app.web.pavelk.db1.repo;

import app.web.pavelk.db1.model.Woman;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

public interface WomanRep extends JpaRepository<Woman, Long> {

    @EntityGraph(value = "eg1", type = EntityGraph.EntityGraphType.FETCH)
    @Query("select w from Woman w")
    List<Woman> findAllE();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "10000")})
    @Query("select w from Woman w where w.id = :id")
    Optional<Woman> findByIdAndBlock(Long id);


    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    @Query( value = "SELECT * from test1.womans w  WHERE w.id = :id", nativeQuery = true)
    Optional<Object> findByIdNative(Long id);



}
