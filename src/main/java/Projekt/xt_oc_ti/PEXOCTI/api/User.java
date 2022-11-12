package Projekt.xt_oc_ti.PEXOCTI.api;

import java.util.List;

public class User {
    Long id;
    String vorname;
    String nachname;
    String benutzername;
    String passwort;
    List<Long> kontostandIDs;

    public User(Long id, String vorname, String nachname, String benutzername, String passwort, List<Long> kontostandIDs) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.kontostandIDs = kontostandIDs;
    }

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

    public void setNachname(String nachname) {
        this.nachname = nachname;
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

    public List<Long> getKontostandIDs() {
        return kontostandIDs;
    }

    public void setKontostandIDs(List<Long> kontostandIDs) {
        this.kontostandIDs = kontostandIDs;
    }
}
