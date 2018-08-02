package com.informix.sample.data.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.informix.sample.domain.BusinessEntity;

@Repository
public class InformixRepository {

	private final Logger log = LoggerFactory.getLogger(InformixRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public InformixRepository() {
	}

	public InformixRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setDataSource(javax.sql.DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void retrieve() {
		jdbcTemplate
				.query("SELECT entity_id, entity_nm, entity_typ FROM entity WHERE entity_id =  ?",
						new Object[] { "19981215793" },
						(rs, rowNum) -> new BusinessEntity(rs.getLong("entity_id"), rs.getString("entity_nm"),
								rs.getString("entity_typ")))
				.forEach(businessEntity -> log.info("------>" + businessEntity.toString()));

		List<BusinessEntity> result = jdbcTemplate.query(
				"SELECT entity_id, entity_nm, entity_typ FROM entity WHERE entity_id =?",
				new Object[] { "19981215793" }, (rs, rowNum) -> new BusinessEntity(rs.getLong("entity_id"),
						rs.getString("entity_nm"), rs.getString("entity_typ")));

		System.out.println(result);
	}
}
