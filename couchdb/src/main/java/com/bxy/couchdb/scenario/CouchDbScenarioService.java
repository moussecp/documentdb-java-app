package com.bxy.couchdb.scenario;

import com.bxy.domain.Scenario;
import com.bxy.domain.ScenarioRepository;
import com.bxy.domain.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("couchDbScenarioService")
public class CouchDbScenarioService extends ScenarioService {

    @Autowired
    @Qualifier("scenarioRepositoryCouchDBImpl")
    private ScenarioRepository scenarioRepository;

    @Override
    public void add(Scenario scenario) {
        scenarioRepository.add(scenario);
    }

    @Override
    public List<String> findAll() {
        return scenarioRepository.findAll();
    }
}
