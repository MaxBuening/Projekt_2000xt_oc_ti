package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.api.Abgaenge;
import Projekt.xt_oc_ti.PEXOCTI.api.AbgaengeManipulation;
import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserManipulationRequest;
import Projekt.xt_oc_ti.PEXOCTI.persistence.AbgaengeEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.AbgaengeRepository;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AbgaengeService {
    private final AbgaengeRepository abgaengeRepository;

    public AbgaengeService(AbgaengeRepository abgaengeRepository){
        this.abgaengeRepository = abgaengeRepository;
    }
    public List<Abgaenge> findAll(){
        List<AbgaengeEntity> abgaenge = abgaengeRepository.findAll();
        return abgaenge.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Abgaenge create(AbgaengeManipulation request){
        //var AbgaengeEntity = new AbgaengeEntity(request.ge);
        //userEntity = userRepository.save(userEntity);
        //return transformEntity(userEntity);
        return null;
    }

    private Abgaenge transformEntity(AbgaengeEntity abgaengeEntity){

        return new Abgaenge(
                abgaengeEntity.getId(),
                abgaengeEntity.getUser().getId(),
                abgaengeEntity.getAmount(),
                abgaengeEntity.getBeschriftung(),
                abgaengeEntity.getDatum()
        );
    }
}
