package Projekt.xt_oc_ti.PEXOCTI.api;

import java.time.LocalDate;

public class KontostandManipulation {

    Long benutzerID_Fk;
    Double kontostand;
    LocalDate datum;

    public KontostandManipulation(Long benutzerID_Fk, Double kontostand, LocalDate datum) {
        this.benutzerID_Fk = benutzerID_Fk;
        this.kontostand = kontostand;
        this.datum = datum;
    }

    public Long getBenutzerID_Fk() {
        return benutzerID_Fk;
    }

    public void setBenutzerID_Fk(Long benutzerID_Fk) {
        this.benutzerID_Fk = benutzerID_Fk;
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
