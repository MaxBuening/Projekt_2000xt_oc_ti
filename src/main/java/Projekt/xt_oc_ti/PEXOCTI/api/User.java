package Projekt.xt_oc_ti.PEXOCTI.api;

public class User {
    Long id;
    String Vorname;
    String Nachname;
    double income;

    public User(Long id,String vorname, String nachname, double income) {
        this.id = id;
        Vorname = vorname;
        Nachname = nachname;
        this.income = income;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
