package app.web.pavelk.db1.service;

import app.web.pavelk.db1.repo.WomanRep;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Transactional
public class MainService implements CommandLineRunner {

    private final WomanRep womanRep;
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

            } else if (next.equals("0")) {
                break;
            }
        }
    }
}
