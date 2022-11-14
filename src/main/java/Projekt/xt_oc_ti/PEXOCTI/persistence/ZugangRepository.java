package Projekt.xt_oc_ti.PEXOCTI.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ZugangRepository extends JpaRepository<ZugangEntity, Long>{
}