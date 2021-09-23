package app.web.pavelk.db1.service;

import app.web.pavelk.db1.model.Setting;
import app.web.pavelk.db1.model.Woman;
import app.web.pavelk.db1.repo.InfoRep;
import app.web.pavelk.db1.repo.WomanRep;
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
    private final WomanRep womanRep;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = IllegalAccessError.class)
    public void createInfo2() {
        try {
            int i1 = entityManager.createNativeQuery("INSERT INTO " +
                            " test1.infos   (info1, json2, uuid1)  values " +
                            "('bbbbbbbbbbbb', cast(:jsonC1 as jsonb), :uuid1) ")
                    .setParameter("jsonC1", objectMapper.writeValueAsString(
                            TestDate.builder().s1("json b").s2(" jjjj jjj jj").build()))
                    .setParameter("uuid1", UUID.randomUUID())
                    .executeUpdate();
            System.out.println(i1);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updateSettingW1() {

        Woman woman = womanRep.findByIdAndBlock(1L).get();
        System.out.println(woman.getSetting());
        System.out.println("--");
        try {
            Setting setting = woman.getSetting();
            Long sid = null;
            if (setting != null) {
                sid = setting.getId().equals(1L) ? 2L : 1L;
            }
            System.out.println(entityManager.createNativeQuery("UPDATE test1.womans SET setting_id = " + sid + " WHERE id = 1 ").executeUpdate());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("update ------------------ ");
        Woman woman1 = womanRep.saveAndFlush(woman);
        System.out.println(woman1.getSetting());

        //Phantom reads!
        System.out.println("phantom ------------------ ");
        Woman woman2 = womanRep.findById(1L).get();
        System.out.println(woman2.getSetting());

        System.out.println("native manager ------------------ ");
        Object[] o = (Object[]) entityManager.createNativeQuery("SELECT * from test1.womans  WHERE id = 1 ").getSingleResult();
        System.out.println(o[3]);

        System.out.println("clear ------------------ ");
        entityManager.clear();
        Woman woman5 = womanRep.findById(1L).get();
        System.out.println(woman5.getSetting());

        //Phantom reads!
        System.out.println("native repo phantom ------------------ ");
        Object[] o2 = (Object[]) womanRep.findByIdNative(1L).get();
        System.out.println(o2[3]);

        System.out.println("just yet ------------------ ");
        Woman woman6 = womanRep.findById(1L).get();
        System.out.println(woman6.getSetting());

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