package com.bxy.mongodb.db;

import com.bxy.mongodb.scenario.ScenarioMongoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScenarioRepositoryMongoDB extends MongoRepository<ScenarioMongoDTO, String> {

}
