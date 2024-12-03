package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digitalNation.Cititor;

@Repository
public interface CititorRepository extends JpaRepository<Cititor, Long> {
    List<Cititor> findByName(String name);
    List<Cititor> findByEmail(String email);
    List<Cititor> findByAbonamentActiv(boolean activ);
    boolean existsByEmail(String email);
}