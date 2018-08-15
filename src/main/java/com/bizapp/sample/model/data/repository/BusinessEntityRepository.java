package com.bizapp.sample.model.data.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bizapp.sample.model.domain.BusinessEntity;

/**
 * Demonstrates use of CrudRepository
 * 
 * @author
 *
 */
public interface BusinessEntityRepository extends CrudRepository<BusinessEntity, Long> {

	List<BusinessEntity> findByEntityName(String entityName);

	@Query("SELECT e FROM BusinessEntity e WHERE e.entityName LIKE %:entityName% ORDER BY e.entityId ASC")
	Stream<BusinessEntity> findByPartialEntityName(@Param("entityName") String entityName);

	// custom query example and return a stream
	@Query("SELECT e FROM BusinessEntity e WHERE e.entityId = :entityId")
	Stream<BusinessEntity> findByEntityIdReturnStream(@Param("entityId") long entityId);

}