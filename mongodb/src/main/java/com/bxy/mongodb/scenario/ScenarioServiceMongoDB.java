package com.bxy.mongodb.scenario;

import com.bxy.domain.Action;
import com.bxy.domain.ScenarioStep;
import com.bxy.mongodb.db.ScenarioRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioServiceMongoDB {

    @Autowired
    private ScenarioRepositoryMongoDB scenarioRepository;

    public void add(ScenarioMongoDTO scenario) {
        scenarioRepository.save(scenario);
    }

    public List<ScenarioMongoDTO> findAll() {
        return scenarioRepository.findAll();
    }

    public ScenarioMongoDTO createSimpleScenario(String name) {
        return scenarioRepository.save(new ScenarioMongoDTO(getCurrentScenarioId(), name, "BXY", LocalDateTime.now(), getScenarioSteps()));
    }

    private String getCurrentScenarioId() {
        return String.valueOf(scenarioRepository.count() + 1);
    }

    public List<ScenarioMongoDTO> generateScenarios(int numberOfScenarios) {
        List<ScenarioMongoDTO> scenarios = new ArrayList<>();
        for(int i = 0; i<numberOfScenarios; i++) {
            scenarios.add(createSimpleScenario("scenario-number-" + i));
        }
        return scenarios;
    }

    private List<String> getScenarioSteps() {
        List<String> scenarioSteps = new ArrayList<>();
        scenarioSteps.add(Action.START_TRAIN.name());
        scenarioSteps.add(Action.SET_SPEED_TO_SLOW.name());
        scenarioSteps.add(Action.STOP_TRAIN.name());
        scenarioSteps.add(Action.START_TRAIN.name());
        scenarioSteps.add(Action.SET_SPEED_TO_FAST.name());
        scenarioSteps.add(Action.ADD_DELAY.name());
        scenarioSteps.add(Action.SET_SPEED_TO_NORMAL.name());
        return scenarioSteps;
    }
}
