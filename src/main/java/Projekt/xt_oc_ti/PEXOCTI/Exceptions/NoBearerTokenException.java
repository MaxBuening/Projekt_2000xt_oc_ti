package Projekt.xt_oc_ti.PEXOCTI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoBearerTokenException extends ResponseStatusException {
    public NoBearerTokenException() {super(HttpStatus.BAD_REQUEST, "kein Besitzer eines Refresh-Tokens");}
}
