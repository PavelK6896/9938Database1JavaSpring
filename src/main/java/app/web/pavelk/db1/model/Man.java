package app.web.pavelk.db1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "eg11",
                attributeNodes = {
                        @NamedAttributeNode(value = "sons")
                }
        ),
        @NamedEntityGraph(
                name = "eg12",
                attributeNodes = {
                        @NamedAttributeNode(value = "daughters")
                }
        )
})
@Entity
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


    @ToString.Exclude
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "mans_sons", schema = "test1",
            joinColumns = @JoinColumn(name = "man_id"),
            inverseJoinColumns = @JoinColumn(name = "sons_id"))
    private List<Man> sons = new ArrayList<>();


    @ToString.Exclude
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "mans_daughters", schema = "test1",
            joinColumns = @JoinColumn(name = "man_id"),
            inverseJoinColumns = @JoinColumn(name = "daughters_id"))
    private List<Woman> daughters = new ArrayList<>();

    @ToString.Exclude
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id", referencedColumnName = "id")
    private Info info;

    @ToString.Exclude
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "setting_id", referencedColumnName = "id")
    private Setting setting;

}
