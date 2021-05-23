package bm.app.macedonianarmyjpahibernate.repository;

import bm.app.macedonianarmyjpahibernate.model.Macedonian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacedonianRepository extends JpaRepository<Macedonian, Long> {
}
