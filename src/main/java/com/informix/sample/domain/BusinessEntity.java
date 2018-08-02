package com.informix.sample.domain;

public class BusinessEntity {

	long entityId;
	String entityName;
	String entityType;

	public BusinessEntity(long entityId, String entityName, String entityType) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.entityType = entityType;
	}

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@Override
	public String toString() {
		return "BusinessEntity [entityId=" + entityId + ", entityName=" + entityName + ", entityType=" + entityType
				+ "]";
	}

}
