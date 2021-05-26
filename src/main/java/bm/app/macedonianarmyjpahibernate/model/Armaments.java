package bm.app.macedonianarmyjpahibernate.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Armaments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @MapsId
    private Macedonian macedonian;
    private String armourType;
    private String weapon;
    private boolean isMounted;


}
