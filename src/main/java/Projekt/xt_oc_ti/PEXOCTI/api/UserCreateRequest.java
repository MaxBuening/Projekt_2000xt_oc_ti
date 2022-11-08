package Projekt.xt_oc_ti.PEXOCTI.api;

public class UserCreateRequest {
    String Vorname;
    String Nachname;
    double income;

    public UserCreateRequest(String vorname, String nachname, double income) {
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
}
