package com.cosy.sun.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.cosy.sun.mongo.module.MongoModule;

@Component
public class MongoDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void saveTest(MongoModule module) {
		mongoTemplate.save(module);
	}
	
	public MongoModule findByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		MongoModule findOne = mongoTemplate.findOne(query, MongoModule.class);
		return findOne;
	}
	
}
