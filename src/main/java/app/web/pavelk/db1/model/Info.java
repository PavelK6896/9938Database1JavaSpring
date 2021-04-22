package app.web.pavelk.db1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "infos", schema = "test1")
public class Info {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "uuid1")
    private UUID uuid1;

    @Column(name = "info1")
    private String info1;

}
