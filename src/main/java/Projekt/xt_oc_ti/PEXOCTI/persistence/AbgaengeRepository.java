package Projekt.xt_oc_ti.PEXOCTI.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbgaengeRepository extends JpaRepository<AbgaengeEntity, Long>{
}