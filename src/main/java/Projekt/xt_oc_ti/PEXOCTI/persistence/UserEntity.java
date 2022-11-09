package Projekt.xt_oc_ti.PEXOCTI.persistence;

import javax.persistence.*;

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
}
