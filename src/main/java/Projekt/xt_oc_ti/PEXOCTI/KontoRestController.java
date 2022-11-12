package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.api.Kontostand;
import Projekt.xt_oc_ti.PEXOCTI.api.KontostandManipulation;
import Projekt.xt_oc_ti.PEXOCTI.service.Kontostandservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class KontoRestController {

    private final Kontostandservice kontostandservice;

    public KontoRestController(Kontostandservice kontostandservice) {
        this.kontostandservice = kontostandservice;
    }

    @GetMapping(path = "/api/user/{id}/kontostand")
    public ResponseEntity<List<Kontostand>> kontostaendeById(@PathVariable Long id){
        return ResponseEntity.ok(kontostandservice.findAll(id));
    }

    @PostMapping(path = "/api/user/{id}/kontostand")
    public ResponseEntity<Void> createKontostand (@PathVariable Long id, @RequestBody KontostandManipulation request) throws URISyntaxException {
        var kontostand = kontostandservice.create(request);
        URI uri = new URI("/api/user/{id}/kontostand/"+ kontostand.getId());
        return ResponseEntity.created(uri).build();
    }

}
