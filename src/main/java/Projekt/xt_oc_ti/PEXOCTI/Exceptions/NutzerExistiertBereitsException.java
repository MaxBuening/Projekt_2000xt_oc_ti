package Projekt.xt_oc_ti.PEXOCTI.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NutzerExistiertBereitsException extends ResponseStatusException {
    public NutzerExistiertBereitsException(){ super(HttpStatus.BAD_REQUEST, "Benutzername existiert bereits");}
}
