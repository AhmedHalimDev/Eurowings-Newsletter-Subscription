package com.newsletter.sub.dataaccessobject;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newsletter.sub.domainobject.SubscriberDO;

/**
 * Database Access Object for subscriber table.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberDO, Long> {

	List<SubscriberDO> findByActive(Boolean active);
	Optional<SubscriberDO> findByEmail(String email);
	@Query(value  = 
		    " SELECT s.id, s.email, s.name, s.active, s.subscribe_date FROM subscriber s" + 
		    " WHERE s.subscribe_date < :date ", nativeQuery = true)
	List<SubscriberDO> findByDate(@Param("date") Date date);
}