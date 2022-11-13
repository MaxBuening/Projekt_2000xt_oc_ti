package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.api.Abgaenge;
import Projekt.xt_oc_ti.PEXOCTI.api.AbgaengeManipulation;
import Projekt.xt_oc_ti.PEXOCTI.service.AbgaengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AbgaengeRestController {

    private final AbgaengeService abgaengeService;

    public AbgaengeRestController(AbgaengeService abgaengeService){
        this.abgaengeService = abgaengeService;
    }

    @PostMapping(path = "/api/user/{id}/abgaenge")
    public ResponseEntity<Void> createAbgang(@PathVariable Long id, @RequestBody AbgaengeManipulation request) throws URISyntaxException {
        var abgang = abgaengeService.create(request);
        URI uri = new URI("/api/user/"+id.toString()+"/"+abgang.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/user/abgaenge/{id}")
    public ResponseEntity<Abgaenge> abgaengeById(@PathVariable Long id){
        var abgang = abgaengeService.findById(id);
        return abgang != null ? ResponseEntity.ok(abgang) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "api/user/abgaenge")
    public ResponseEntity<List<Abgaenge>> abgaenge(){
        return ResponseEntity.ok(abgaengeService.findAll());
    }

    // NOTE: deleteAbgang funktioniert nicht weil der Delete Pfad bei delete user irgendwie ähnlich genug ist,
    //       dass der irgendwie auch ausgeführt wird. Führt zu einem Foreign Key constraint violation weil bie
    //       Bankkonto der User ID irgendwie noch drin ist.

    //@DeleteMapping(path = "/api/user/abgaenge/{id}")
    //public ResponseEntity<Void> deleteAbgang(@PathVariable Long id){
        //boolean success = abgaengeService.deleteById(id);
        //return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    //}
}
