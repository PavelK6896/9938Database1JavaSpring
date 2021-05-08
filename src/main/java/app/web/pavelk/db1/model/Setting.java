package app.web.pavelk.db1.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "setting", schema = "test1")
public class Setting {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @ToString.Exclude
    @JsonBackReference
    @OneToOne(mappedBy = "setting")
    private Woman woman;

}
