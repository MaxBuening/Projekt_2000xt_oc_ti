package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.api.Zugang;
import Projekt.xt_oc_ti.PEXOCTI.api.ZugangManipulation;

import Projekt.xt_oc_ti.PEXOCTI.service.ZugangService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ZugangRestController {

    private final ZugangService zugangService;

    public ZugangRestController(ZugangService zugangService){
        this.zugangService = zugangService;
    }

    @PostMapping(path = "/api/user/zugang")
    public ResponseEntity<Void> createZugang(@RequestBody ZugangManipulation request) throws URISyntaxException {
        var zugang = zugangService.create(request);
        URI uri = new URI("/api/user/"+zugang.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/user/zugang/{id}")
    public ResponseEntity<Zugang> ZugaengeById(@PathVariable Long id){
        var zugang = zugangService.findById(id);
        return zugang != null ? ResponseEntity.ok(zugang) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "api/user/zugang")
    public ResponseEntity<List<Zugang>> zugang(){
        return ResponseEntity.ok(zugangService.findAll());
    }

    // NOTE: Der Text hier drunter gilt auch hier, aber halt mit Zugang anstatt Abgang
    // NOTE: deleteAbgang funktioniert nicht weil der Delete Pfad bei delete user irgendwie ähnlich genug ist,
    //       dass der irgendwie auch ausgeführt wird. Führt zu einem Foreign Key constraint violation weil bie
    //       Bankkonto der User ID irgendwie noch drin ist.

    //@DeleteMapping(path = "/api/user/abgaenge/{id}")
    //public ResponseEntity<Void> deleteAbgang(@PathVariable Long id){
    //boolean success = abgaengeService.deleteById(id);
    //return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    //}
}
