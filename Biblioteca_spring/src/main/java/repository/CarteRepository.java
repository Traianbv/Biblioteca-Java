package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalNation.Carte;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long>{
	
	List<Carte> findByDisponibila(boolean disponibila);
    List<Carte> findByTitluContainingIgnoreCaseAndDisponibila(String titlu, boolean disponibila);
}
