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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "eg1",
                attributeNodes = {
                        @NamedAttributeNode(value = "daughters")
                }
        ),
        @NamedEntityGraph(
                name = "eg2",
                attributeNodes = {
                        @NamedAttributeNode(value = "sons")
                }
        )
})
@Entity
@Table(name = "womans", schema = "test1")
public class Woman {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "womans_daughters", schema = "test1",
            joinColumns = @JoinColumn(name = "women_id"),
            inverseJoinColumns = @JoinColumn(name = "daughters_id"))
    private List<Woman> daughters = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "womans_sons", schema = "test1",
            joinColumns = @JoinColumn(name = "women_id"),
            inverseJoinColumns = @JoinColumn(name = "sons_id"))
    private List<Man> sons = new ArrayList<>();


}
