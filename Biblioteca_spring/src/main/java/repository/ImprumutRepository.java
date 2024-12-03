package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalNation.Imprumut;

@Repository
public interface ImprumutRepository extends JpaRepository<Imprumut, Long>{
	
    List<Imprumut> findByCititorId(Long cititorId);
    List<Imprumut> findByCarteId(Long carteId);
    List<Imprumut> findByReturnatFalseAndDataReturnareBefore(Date data);
	
	

}
