package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserCreateRequest;
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

    public User create(UserCreateRequest request){
        var userEntity = new UserEntity(request.getVorname(), request.getNachname(), request.getBenutzername(), request.getPasswort());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    private User transformEntity(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getVorname(),
                userEntity.getNachnahme(),
                userEntity.getBenutzername(),
                userEntity.getPasswort()
        );
    }


}
