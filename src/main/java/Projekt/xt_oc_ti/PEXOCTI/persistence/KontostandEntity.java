package Projekt.xt_oc_ti.PEXOCTI.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Kontostand")
public class KontostandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "benutzerId_Fk", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "Kontostand")
    private Double kontostand;

    @Column(name = "Datum")
    private LocalDate datum;

    public KontostandEntity() {
    }

    public KontostandEntity(UserEntity user, Double kontostand, LocalDate datum) {
        this.user = user;
        this.kontostand = kontostand;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Double getKontostand() {
        return kontostand;
    }

    public void setKontostand(Double kontostand) {
        this.kontostand = kontostand;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
