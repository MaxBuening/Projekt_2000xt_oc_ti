package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.api.Kontostand;
import Projekt.xt_oc_ti.PEXOCTI.api.KontostandManipulation;
import Projekt.xt_oc_ti.PEXOCTI.persistence.KontostandEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.KontostandRepository;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Kontostandservice {

    private final KontostandRepository kontostandrepository;
    private final UserRepository userRepository;

    public Kontostandservice(KontostandRepository kontostandrepository, UserRepository userRepository) {
        this.kontostandrepository = kontostandrepository;
        this.userRepository = userRepository;
    }

    public List<Kontostand> findAll(Long id){
    var kontostand = kontostandrepository.findAllById(Collections.singleton(id));
    return kontostand.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Kontostand create(KontostandManipulation request){
        var benutzer = userRepository.findById(request.getBenutzerID_Fk()).orElseThrow();
        var kontostandentity = new KontostandEntity(benutzer, request.getKontostand(), request.getDatum());
        kontostandentity = kontostandrepository.save(kontostandentity);
        return transformEntity(kontostandentity);
    }


    private Kontostand transformEntity(KontostandEntity kontostandEntity){
        return new Kontostand(
          kontostandEntity.getId(),
          kontostandEntity.getUser().getId(),
          kontostandEntity.getKontostand(),
          kontostandEntity.getDatum()
        );
    }
}
