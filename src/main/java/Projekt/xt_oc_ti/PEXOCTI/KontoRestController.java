package Projekt.xt_oc_ti.PEXOCTI;

import Projekt.xt_oc_ti.PEXOCTI.service.Kontostandservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KontoRestController {
    private final Kontostandservice;

    public KontoRestController() {
    }

    @GetMapping(path = "/api/user/{id}/kontostand")

}
