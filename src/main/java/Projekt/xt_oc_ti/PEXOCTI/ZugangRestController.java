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

    @DeleteMapping (path = "/api/user/zugang/{id}")
    public ResponseEntity<Void> deleteZugang (@PathVariable Long id){
        return zugangService.deleteById(id)? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
