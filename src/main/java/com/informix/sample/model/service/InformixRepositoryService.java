package com.informix.sample.model.service;

import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import com.informix.sample.data.repository.BusinessEntityRepository;
import com.informix.sample.data.repository.InformixRepository;
import com.informix.sample.domain.BusinessEntity;

@Named
public class InformixRepositoryService {

	@Inject
	DataSource dataSource;

	@Inject
	private InformixRepository informixRepository;
	

	@Inject
	private BusinessEntityRepository businessEntityRepository;


	public void retrieve() {
		System.out.println("-------->DATASOURCE = " + dataSource);

		informixRepository.retrieve();
		

	}

	public void retrieveByEntityId (long entityId) {
		System.out.println("-------->DATASOURCE = " + dataSource);

		Stream<BusinessEntity> stream = businessEntityRepository.findByEntityIdReturnStream(entityId);
		stream.forEach(x -> System.out.println (x));
	}

}
