package com.bxy.couchdb.db;

import com.bxy.couchdb.scenario.ScenarioCouchDTO;
import com.bxy.couchdb.scenario.ScenarioCouchDTOFactory;
import com.bxy.domain.Scenario;
import com.bxy.domain.ScenarioRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ektorp.CouchDbConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository("scenarioRepositoryCouchdbImpl")
public class ScenarioRepositoryCouchdbImpl implements ScenarioRepository {

    @Autowired
    CouchDbConnector db;
    @Autowired
    ScenarioCouchDTOFactory scenarioCouchDTOFactory;

    @Override
    public List<String> findAll() {
        List<String> scenarios = new ArrayList<>();
        for (String docId : db.getAllDocIds()) {
            scenarios.add(db.find(JsonNode.class, docId).toString());
        }
        return scenarios;
    }

    @Override
    public void add(Scenario scenario) {
        add(scenarioCouchDTOFactory.convertScenario(scenario));
    }

    private void add(ScenarioCouchDTO scenario) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            long currentId = db.getAllDocIds().stream()
                    .map(Long::valueOf)
                    .max(Long::compareTo)
                    .orElse(0L)
                    + 1L;
            File file = new File("web-" + currentId + ".json");
            mapper.writeValue(file, scenario);
            JsonNode jsonItem = mapper.readTree(mapper.writeValueAsString(scenario));

            db.create(String.valueOf(currentId), jsonItem);
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
