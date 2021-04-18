package app.web.pavelk.db1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mans", schema = "test1")
public class Man {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference
    @JoinTable(name = "womans_sons", schema = "test1",
            joinColumns = @JoinColumn(name = "sons_id"),
            inverseJoinColumns = @JoinColumn(name = "women_id"))
    private Woman woman;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "mans_sons", schema = "test1",
            joinColumns = @JoinColumn(name = "man_id"),
            inverseJoinColumns = @JoinColumn(name = "sons_id"))
    private List<Man> sons = new ArrayList<>();



}
