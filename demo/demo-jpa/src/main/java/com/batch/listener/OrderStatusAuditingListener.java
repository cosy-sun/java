package com.batch.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import org.hibernate.internal.CriteriaImpl.OrderEntry;

public class OrderStatusAuditingListener {

	@PostPersist
	private void postPersist(OrderEntry entry) {
		
	}
	
	@PostRemove
	private void postRemove(OrderEntry entry) {
		
	}
	
	@PostUpdate
	private void postUpdate(OrderEntry entry) {
		
	}
	
}
