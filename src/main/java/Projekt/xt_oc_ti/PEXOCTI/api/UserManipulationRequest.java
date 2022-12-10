package Projekt.xt_oc_ti.PEXOCTI.api;

public class UserManipulationRequest {
    String vorname;
    String nachname;
    String benutzername;
    String passwort;

    public UserManipulationRequest(String vorname, String nachname, String benutzername, String passwort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    public UserManipulationRequest() {
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
}
