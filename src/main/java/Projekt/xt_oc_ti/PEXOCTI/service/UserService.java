package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserManipulationRequest;
import Projekt.xt_oc_ti.PEXOCTI.persistence.KontostandEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        List<UserEntity> user = userRepository.findAll();
        return user.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public User findById(Long id){
        var userEntity = userRepository.findById(id);
        return userEntity.map(this::transformEntity).orElse(null);
    }

    public User create(UserManipulationRequest request){
        var userEntity = new UserEntity(request.getVorname(), request.getNachname(), request.getBenutzername(), request.getPasswort());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public User update (Long id, UserManipulationRequest request){
        var userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isEmpty()) return null;
        var userEntity = userEntityOptional.get();
        userEntity.setVorname(request.getVorname());
        userEntity.setNachname(request.getNachname());
        userEntity.setBenutzername(request.getBenutzername());
        userEntity.setPasswort(request.getPasswort());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public boolean deleteById (Long id){
        var userEntityOptional = userRepository.findById(id);
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private User transformEntity(UserEntity userEntity){
        var kontostandIds = userEntity.getKontostand().stream().map(KontostandEntity::getId).collect(Collectors.toList());
        return new User(
                userEntity.getId(),
                userEntity.getVorname(),
                userEntity.getNachname(),
                userEntity.getBenutzername(),
                userEntity.getPasswort(),
                kontostandIds
        );
    }



}
