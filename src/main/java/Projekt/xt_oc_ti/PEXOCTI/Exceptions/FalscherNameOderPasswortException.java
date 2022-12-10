package Projekt.xt_oc_ti.PEXOCTI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FalscherNameOderPasswortException extends ResponseStatusException {
    public FalscherNameOderPasswortException() {
        super(HttpStatus.BAD_REQUEST, "Nutzername oder Passwort falsch");
    }
}
