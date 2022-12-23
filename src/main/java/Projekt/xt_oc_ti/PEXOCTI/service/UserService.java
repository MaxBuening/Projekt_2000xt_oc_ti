package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.Exceptions.BenutzerNichtGefundenException;
import Projekt.xt_oc_ti.PEXOCTI.Exceptions.FalscherNameOderPasswortException;
import Projekt.xt_oc_ti.PEXOCTI.Exceptions.NutzerExistiertBereitsException;
import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserManipulationRequest;
import Projekt.xt_oc_ti.PEXOCTI.persistence.KontostandEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserRepository;
import Projekt.xt_oc_ti.PEXOCTI.persistence.ZugangEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String accessTokenSecret;
    private final String refreshTokenSecret;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, @Value("${application.access-token-secret}") String accessTokenSecret, @Value("${application.refresh-token-secret}") String refreshTokenSecret) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accessTokenSecret = accessTokenSecret;
        this.refreshTokenSecret = refreshTokenSecret;
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
        var userEntity = new UserEntity(request.getVorname(), request.getNachname(), request.getBenutzername(), passwordEncoder.encode(request.getPasswort()));

        try{
            userEntity = userRepository.save(userEntity);
        }catch (DataIntegrityViolationException exception){
            throw new NutzerExistiertBereitsException();
        }

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
        var kontostandIds = userEntity.getKontostand().stream().map(ZugangEntity::getId).collect(Collectors.toList());
        return new User(
                userEntity.getId(),
                userEntity.getVorname(),
                userEntity.getNachname(),
                userEntity.getBenutzername(),
                userEntity.getPasswort(),
                kontostandIds
        );
    }

    public Login login(String nutzername, String passwort){
        var user = userRepository.findByBenutzername(nutzername).orElseThrow(FalscherNameOderPasswortException::new);
        User us = transformEntity(user);

        if(!passwordEncoder.matches(passwort, us.getPasswort())) throw new FalscherNameOderPasswortException();
        return Login.of(us.getId(), accessTokenSecret, refreshTokenSecret);
    }

    public User getBenutzerFromToken(String token){
        return transformEntity(userRepository.findById(Jwt.from(token, accessTokenSecret).getUserId()).orElseThrow(BenutzerNichtGefundenException::new));
    }

    public Login refreshAccess(String refreshToken){
        var refreshJwt = Jwt.from(refreshToken, refreshTokenSecret);
        return Login.of(refreshJwt.getUserId(), accessTokenSecret,refreshJwt);
    }

}
