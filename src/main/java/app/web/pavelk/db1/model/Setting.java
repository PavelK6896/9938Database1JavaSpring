package app.web.pavelk.db1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
