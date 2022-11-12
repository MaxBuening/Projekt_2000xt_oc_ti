package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.api.Abgaenge;
import Projekt.xt_oc_ti.PEXOCTI.api.AbgaengeManipulation;
import Projekt.xt_oc_ti.PEXOCTI.service.AbgaengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbgaengeRestController {

    private final AbgaengeService abgaengeService;

    public AbgaengeRestController(AbgaengeService abgaengeService){
        this.abgaengeService = abgaengeService;
    }

    @GetMapping(path = "/api/user/{id}/abgaenge")
    public ResponseEntity<Abgaenge> createAbgang(@PathVariable Long id,
                                                 @RequestBody AbgaengeManipulation request){
        var Abgaenge = abgaengeService.create(request);
        return null;
    }
}
