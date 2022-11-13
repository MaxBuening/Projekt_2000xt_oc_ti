package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.api.Abgaenge;
import Projekt.xt_oc_ti.PEXOCTI.api.AbgaengeManipulation;
import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserManipulationRequest;
import Projekt.xt_oc_ti.PEXOCTI.persistence.AbgaengeEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.AbgaengeRepository;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbgaengeService {
    private final AbgaengeRepository abgaengeRepository;
    private final UserRepository userRepository;

    public AbgaengeService(AbgaengeRepository abgaengeRepository, UserRepository userRepository){
        this.abgaengeRepository = abgaengeRepository;
        this.userRepository = userRepository;
    }

    public List<Abgaenge> findAll(){
        List<AbgaengeEntity> abgaenge = abgaengeRepository.findAll();
        return abgaenge.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Abgaenge findById(Long id){
        var abgaengeEntity = abgaengeRepository.findById(id);
        return abgaengeEntity.map(this::transformEntity).orElse(null);
    }

    public Abgaenge create(AbgaengeManipulation request){
        var benutzer = userRepository.findById(request.getBenutzerID_Fk()).orElseThrow();
        var abgangEntity = new AbgaengeEntity(benutzer, request.getAmount(), request.getBeschriftug(), request.getDatum());
        abgangEntity = abgaengeRepository.save(abgangEntity);
        return transformEntity(abgangEntity);
    }

    public boolean deleteById(Long id){
        var abgaengeEntity = abgaengeRepository.findById(id);
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
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
