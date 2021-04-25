package app.web.pavelk.db1.service;

import app.web.pavelk.db1.repo.InfoRep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WriteService {

    private final InfoRep infoRep;
    private final EntityManager entityManager;
    private final ObjectMapper objectMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = IllegalAccessError.class)
    public void createInfo() {
        try {
            int i1 = entityManager.createNativeQuery("INSERT INTO " +
                    " test1.infos   (info1, json1, uuid1)  values " +
                    "('dasdasda', cast(:jsonC1 as json), :uuid1) ")
                    .setParameter("jsonC1", objectMapper.writeValueAsString(TestDate.builder().s1("ddddddddddd").build()))
                    .setParameter("uuid1", UUID.randomUUID())
                    .executeUpdate();
            System.out.println(i1);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class TestDate {
    String s1;
    String s2;
}