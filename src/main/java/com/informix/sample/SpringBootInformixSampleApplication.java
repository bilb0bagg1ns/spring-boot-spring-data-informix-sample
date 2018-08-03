package com.informix.sample;

import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.informix.sample.model.service.InformixRepositoryService;

@SpringBootApplication
public class SpringBootInformixSampleApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootInformixSampleApplication.class);

	@Inject
	private InformixRepositoryService informixRepositoryService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInformixSampleApplication.class, args);
	}

	@Transactional(readOnly = true)
	@Override
	public void run(String... strings) throws Exception {
		log.info("------Querying Informix Table");
		informixRepositoryService.retrieve();
		

		informixRepositoryService.retrieveByEntityId(19981215793l);

		
		
	}

}