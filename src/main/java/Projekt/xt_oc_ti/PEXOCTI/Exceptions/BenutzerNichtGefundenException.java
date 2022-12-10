package Projekt.xt_oc_ti.PEXOCTI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BenutzerNichtGefundenException extends ResponseStatusException {
    public BenutzerNichtGefundenException(){super(HttpStatus.NOT_FOUND, "Benutzer nicht gefunden");}
}
