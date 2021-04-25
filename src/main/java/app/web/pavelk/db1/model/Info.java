package app.web.pavelk.db1.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "infos", schema = "test1")
public class Info implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "uuid1")
    private UUID uuid1;

    @Column(name = "info1")
    private String info1;

    @Column(name = "json1", columnDefinition = "json")
    @ToString.Exclude
    @JsonBackReference
    private String json1;

}
