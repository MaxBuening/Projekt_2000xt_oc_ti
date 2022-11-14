package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.api.*;
import Projekt.xt_oc_ti.PEXOCTI.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZugangService {
    private final ZugangRepository zugangRepository;
    private final UserRepository userRepository;

    public ZugangService(ZugangRepository zugangRepository, UserRepository userRepository){
        this.zugangRepository = zugangRepository;
        this.userRepository = userRepository;
    }

    public List<Zugang> findAll(){
        List<ZugangEntity> zugang = zugangRepository.findAll();
        return zugang.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Zugang findById(Long id){
        var zugangEntity = zugangRepository.findById(id);
        return zugangEntity.map(this::transformEntity).orElse(null);
    }

    public Zugang create(ZugangManipulation request){
        var benutzer = userRepository.findById(request.getBenutzerID_Fk()).orElseThrow();
        var zugangEntity = new ZugangEntity(benutzer, request.getAmount(), request.getBeschriftug(), request.getDatum());
        zugangEntity = zugangRepository.save(zugangEntity);
        return transformEntity(zugangEntity);
    }

    public boolean deleteById(Long id){
        var zugangEntity = zugangRepository.findById(id);
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Zugang transformEntity(ZugangEntity zugangEntity){

        return new Zugang(
                zugangEntity.getId(),
                zugangEntity.getUser().getId(),
                zugangEntity.getAmount(),
                zugangEntity.getBeschriftung(),
                zugangEntity.getDatum()
        );
    }
}
