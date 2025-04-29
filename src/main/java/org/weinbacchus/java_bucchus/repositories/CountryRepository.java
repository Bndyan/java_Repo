package org.weinbacchus.java_bucchus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weinbacchus.java_bucchus.model.Country;

/**
 * Die Klasse CountryRepository
 *
 * @author k.bndyan
 * @version 1.0
 * @date 02.12.2024
 */
@Repository
public interface CountryRepository  extends JpaRepository<Country, Long> {


}
