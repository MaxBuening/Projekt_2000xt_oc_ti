package Projekt.xt_oc_ti.PEXOCTI.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Zugaenge")
public class ZugangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "benutzerId_Fk",referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "Beschriftung")
    private String beschriftung;

    @Column(name = "Datum")
    private LocalDate datum;

    public ZugangEntity(){
    }

    public ZugangEntity(UserEntity user, Double amount, String beschriftung, LocalDate datum){
        this.user = user;
        this.amount = amount;
        this.beschriftung = beschriftung;
        this.datum = datum;
    }

    public Long getId(){
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBeschriftung() {
        return beschriftung;
    }

    public void setBeschriftung(String beschriftung) {
        this.beschriftung = beschriftung;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
