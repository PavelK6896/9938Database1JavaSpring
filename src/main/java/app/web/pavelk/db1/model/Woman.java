package app.web.pavelk.db1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "womans", schema = "test1")
public class Woman {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "womans_daughters", schema = "test1",
            joinColumns = @JoinColumn(name = "women_id"),
            inverseJoinColumns = @JoinColumn(name = "daughters_id"))
    private List<Woman> daughters = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "womans_sons", schema = "test1",
            joinColumns = @JoinColumn(name = "women_id"),
            inverseJoinColumns = @JoinColumn(name = "sons_id"))
    private List<Man> sons = new ArrayList<>();


}
