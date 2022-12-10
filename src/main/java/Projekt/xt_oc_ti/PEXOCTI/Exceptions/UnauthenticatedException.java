package Projekt.xt_oc_ti.PEXOCTI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnauthenticatedException extends ResponseStatusException {
    public UnauthenticatedException() {
        super(HttpStatus.UNAUTHORIZED, "Nicht Autorisiert");
    }
}
