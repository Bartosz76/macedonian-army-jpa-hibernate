package bm.app.macedonianarmyjpahibernate.repository;

import bm.app.macedonianarmyjpahibernate.model.Macedonian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MacedonianRepository extends JpaRepository<Macedonian, Long> {

    /**
     * Below is a custom method that's never defined in any way, shape or form.
     * And it still works like a charm.
     * It's thanks to 'Query DSL' -> Domain Specific Language. Depending on what
     * variables I have, JPA will provide me the queries.
     * There's a particular pattern I need to follow though - it should be either
     * 'getBy' or 'findBy' and it needs to be followed by a variable name with
     * the first letter being a capital one.
     */

    // It's a list because there may be more than one soldier with the provided name.
    List<Macedonian> findByName(String name);

    /**
     * I can also set the ordering.
     */

    List<Macedonian> findByUnitOrderById(String unit);

    /**
     * Query annotation.
     * By default, JpaRepository looks for records with the help of the Primary Key.
     * I can create methods like 'findBY()' to change that, but I can also use a
     * Query instead of methods.
     * SpringbootData provides such a feature.
     */

    @Query("from Macedonian where name = :providedName")
    List<Macedonian> find(@Param("providedName") String name);


}
