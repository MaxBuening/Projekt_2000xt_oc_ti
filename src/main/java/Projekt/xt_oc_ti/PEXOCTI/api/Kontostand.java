package Projekt.xt_oc_ti.PEXOCTI.api;

import java.time.LocalDate;

public class Kontostand {

    Long id;
    Long benutzerID_Fk;
    Double kontostand;
    LocalDate datum;

    public Kontostand(Long id, Long benutzerID_Fk, Double kontostand, LocalDate datum) {
        this.id = id;
        this.benutzerID_Fk = benutzerID_Fk;
        this.kontostand = kontostand;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
