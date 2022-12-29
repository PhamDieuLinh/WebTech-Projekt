package htw.berlin.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BewertungRepository extends JpaRepository<BewertungEntity, Long> {
    List<BewertungEntity> findAllByName(String name);
}
