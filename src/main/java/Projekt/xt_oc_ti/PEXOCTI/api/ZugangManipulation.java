package Projekt.xt_oc_ti.PEXOCTI.api;

import java.time.LocalDate;

public class ZugangManipulation {
    Long benutzerID_Fk;
    Double amount;
    String beschriftug;
    LocalDate datum;
    public ZugangManipulation(Long benutzerID_Fk, Double amount, String beschriftung, LocalDate datum){
        this.benutzerID_Fk = benutzerID_Fk;
        this.amount = amount;
        this.beschriftug = beschriftung;
        this.datum = datum;
    }

    public ZugangManipulation() {
    }

    public Long getBenutzerID_Fk() {
        return benutzerID_Fk;
    }

    public void setBenutzerID_Fk(Long benutzerID_Fk) {
        this.benutzerID_Fk = benutzerID_Fk;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBeschriftug() {
        return beschriftug;
    }

    public void setBeschriftung(String beschriftung) {
        this.beschriftug = beschriftung;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
