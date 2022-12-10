package Projekt.xt_oc_ti.PEXOCTI.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByBenutzername(String nutername);
    List<UserEntity> findAllByVorname(String vorname);


}
