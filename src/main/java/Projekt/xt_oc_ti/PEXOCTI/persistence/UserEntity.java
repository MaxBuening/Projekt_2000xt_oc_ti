package Projekt.xt_oc_ti.PEXOCTI.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Benutzer")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vorname", nullable = false)
    private String vorname;

    @Column(name = "nachname", nullable = false)
    private String nachname;

    @Column(name = "benutzername", nullable = false)
    private String benutzername;

    @Column(name = "passwort")
    private String passwort;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<KontostandEntity> benutzerId_fk =new ArrayList<>();



    public UserEntity(String vorname, String nachnahme, String benutzername, String passwort) {
        this.vorname = vorname;
        this.nachname = nachnahme;
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    public UserEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachnahme) {
        this.nachname = nachnahme;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public List<KontostandEntity> getKontostand() {return benutzerId_fk;}

    public void setbenutzerId_fk(List<KontostandEntity> kontostand) {this.benutzerId_fk = kontostand;}
}
