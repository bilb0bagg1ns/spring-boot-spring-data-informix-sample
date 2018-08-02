package com.informix.sample.model.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import com.informix.sample.data.repository.InformixRepository;

@Named
public class InformixRepositoryService {

	@Inject
	DataSource dataSource;

	@Inject
	private InformixRepository informixRepository;

	public void retrieve() {
		System.out.println("-------->DATASOURCE = " + dataSource);

		informixRepository.retrieve();

	}
}
