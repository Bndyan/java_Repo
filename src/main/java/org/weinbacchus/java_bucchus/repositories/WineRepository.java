package org.weinbacchus.java_bucchus.repositories;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weinbacchus.java_bucchus.model.Wine;

import java.util.List;

/**
 * Die Klasse WineRepository
 *
 * @author k.bndyan
 * @version 1.0
 * @date 28.11.2024
 */
@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {

    /*
     * Derived Query Methods in Spring Data JPA Repositories
     *
     * https://www.baeldung.com/spring-data-derived-queries
     *
     * JPA Query Methods
     * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
     */
    List<Wine> findByVintage(int vintage);

    List<Wine> findByNameContaining(String infix);

    Wine findByIdWine(long id);

}
