package com.bxy.mongodb.db;

import com.bxy.domain.Scenario;
import com.bxy.domain.ScenarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScenarioRepositoryMongoDBImpl implements ScenarioRepository {

    @Override
    public List<String> findAll() {
        //TODO
        return null;
    }

    @Override
    public void add(Scenario scenario) {
        //TODO
    }
}
