package Projekt.xt_oc_ti.PEXOCTI.api;

import java.time.LocalDate;

public class AbgaengeManipulation {
    Long benutzerID_Fk;
    Double amount;
    String beschriftug;
    LocalDate datum;
    public AbgaengeManipulation(Long benutzerID_Fk, Double amount, String beschriftug, LocalDate datum){
        this.benutzerID_Fk = benutzerID_Fk;
        this.amount = amount;
        this.beschriftug = beschriftug;
        this.datum = datum;
    }

    public AbgaengeManipulation() {
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

    public void setBeschriftug(String beschriftug) {
        this.beschriftug = beschriftug;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
