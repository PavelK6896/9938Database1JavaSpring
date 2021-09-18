package app.web.pavelk.db1.service;

import app.web.pavelk.db1.model.Man;
import app.web.pavelk.db1.model.Setting;
import app.web.pavelk.db1.model.Woman;
import app.web.pavelk.db1.repo.InfoRep;
import app.web.pavelk.db1.repo.ManRep;
import app.web.pavelk.db1.repo.SettingRep;
import app.web.pavelk.db1.repo.WomanRep;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class MainService implements CommandLineRunner {

    private final WomanRep womanRep;
    private final ManRep manRep;
    private final InfoRep infoRep;
    private final SettingRep settingRep;
    private final WriteService writeService;
    private final EntityManager entityManager;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            TimeUnit.MILLISECONDS.sleep(500);
            String next = scanner.next();

            if (next.equals("1")) {
                womanRep.findAll().forEach(System.out::println);
            } else if (next.equals("2")) {
                List<Object[]> resultList = entityManager
                        .createNativeQuery("select * from test1.womans as tw full join test1.womans_daughters as td on td.women_id = tw.id;")
                        .getResultList();
                resultList.forEach(f -> {
                    System.out.printf(" " + f[0] + " ");
                    System.out.printf(" " + f[1] + " ");
                    System.out.printf(" " + f[2] + " ");
                    System.out.printf(" " + f[3] + "\n");
                });
            } else if (next.equals("3")) {
                womanRep.findAll().stream().flatMap(f -> f.getDaughters().stream()).forEach(System.out::println);
            } else if (next.equals("4")) {
                womanRep.findAll().stream().flatMap(f -> f.getSons().stream()).forEach(System.out::println);
            } else if (next.equals("5")) {
                System.out.println(womanRep.findAll());
            } else if (next.equals("6")) {
                System.out.println(womanRep.findAllE());
            } else if (next.equals("7")) {

                EntityGraph entityGraph = entityManager.getEntityGraph("eg1");
                List list1 = entityManager.createQuery("select w from Woman w")
                        .getResultList();
                System.out.println(list1.size());

                List list2 = entityManager.createQuery("select w from Woman w")
                        .setHint("javax.persistence.fetchgraph", entityGraph)
                        .getResultList();
                System.out.println(list2.size());

                List list3 = entityManager.createQuery("select w from Woman w")
                        .setHint("javax.persistence.fetchgraph", entityManager.getEntityGraph("eg2"))
                        .getResultList();
                System.out.println(list3.size());

            } else if (next.equals("8")) {

                List<Man> all = manRep.findAll();
                System.out.println(all.size());
                all.forEach(f -> System.out.println(f.getWoman()));

            } else if (next.equals("9")) {

                List<Man> all = manRep.findAll();
                all.stream().flatMap(f -> f.getSons().stream()).forEach(System.out::println);

            } else if (next.equals("10")) {
                List<Man> all = manRep.findAll();

            } else if (next.equals("11")) {
                manRep.findAll().stream().flatMap(f -> f.getDaughters().stream()).forEach(System.out::println);

            } else if (next.equals("12")) {

                manRep.findAllE().forEach(f -> System.out.println(f.getId()));

            } else if (next.equals("13")) {

                manRep.findAll().forEach(f -> System.out.println(f.getId()));

                manRep.findAll(PageRequest.of(0, 1, Sort.by(
                        Sort.Order.desc("id"))))
                        .getContent().forEach(f -> System.out.println(f.getId()));

                manRep.findAll(PageRequest.of(0, 1, Sort.by(
                        Sort.Order.asc("id"))))
                        .getContent().forEach(f -> System.out.println(f.getId()));

            } else if (next.equals("14")) {
                System.out.println(manRep.findAllE12().size());

            } else if (next.equals("15")) {
                manRep.findAllE12().stream().map(f -> f.getDaughters().size()).forEach(System.out::println);
            } else if (next.equals("16")) {

            } else if (next.equals("17")) {

            } else if (next.equals("18")) {
                writeService.updateSettingW1();
            } else if (next.equals("19")) {
                writeService.createInfo();
            } else if (next.equals("20")) {
                writeService.createInfo2();
            } else if (next.equals("21")) {

            } else if (next.equals("22")) {
                settingRep.save(Setting.builder().id(10L).description("333").build());
            } else if (next.equals("23")) {
                List<Man> man = manRep.findAll();
                man.forEach(f -> {
                    f.setSetting(Setting.builder().description("set setting").build());
                });
                manRep.saveAll(man);
            } else if (next.equals("24")) {
                List<Woman> women = womanRep.findAll();
                women.forEach(f -> {
                    f.setSetting(Setting.builder().description("set setting").build());
                });
                womanRep.saveAll(women);

            } else if (next.equals("25")) {
            } else if (next.equals("26")) {
            } else if (next.equals("27")) {
            } else if (next.equals("m")) {
                manRep.findAll().forEach(System.out::println);
            } else if (next.equals("w")) {
                womanRep.findAll().forEach(System.out::println);
            } else if (next.equals("i")) {
                infoRep.findAll().forEach(System.out::println);
            } else if (next.equals("s")) {
                settingRep.findAll().forEach(System.out::println);
            } else if (next.equals("ws")) {
                womanRep.findAll().stream().map(f -> f.getSetting()).forEach(System.out::println);
            } else if (next.equals("sw")) {
                settingRep.findAll().stream().forEach(f -> {
                    System.out.println(f + " -w-> " + f.getWoman());
                });
            } else if (next.equals("ms")) {
                manRep.findAll().stream().map(f -> f.getSetting()).forEach(System.out::println);
            } else if (next.equals("sm")) {
                settingRep.findAll().stream().forEach(f -> {
                    System.out.println(f + " -m-> " + f.getMan());
                });

            } else if (next.equals("0")) {
                break;
            }
        }
    }
}
