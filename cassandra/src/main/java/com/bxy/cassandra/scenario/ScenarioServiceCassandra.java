package com.bxy.cassandra.scenario;

import com.bxy.cassandra.db.ScenarioRepositoryCassandra;
import com.bxy.cassandra.db.ScenarioStepRepositoryCassandra;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.bxy.domain.Action.*;
import static java.time.LocalDateTime.now;

@Service
public class ScenarioServiceCassandra {

    @Autowired
    private ScenarioRepositoryCassandra scenarioRepository;
    @Autowired
    private ScenarioStepRepositoryCassandra scenarioStepRepository;

    public List<Scenario> findAll() {
        return Lists.newArrayList(scenarioRepository.findAll());
    }

    public Scenario createSimpleScenario(String name) {
        Scenario scenario = scenarioRepository
                .save(new Scenario(name, "BXY", now()));
        createScenarioSteps(scenario);
        return scenario;
    }

    public List<Scenario> generateScenarios(int numberOfScenarios) {
        List<Scenario> scenarios = new ArrayList<>();
        for (int i = 0; i < numberOfScenarios; i++) {
            scenarios.add(createSimpleScenario("scenario-number-" + i));
        }
        return scenarios;
    }

    private void createScenarioSteps(Scenario scenario) {
        List<ScenarioStep> scenarioSteps = new ArrayList<>();
        UUID scenarioId = scenario.getId();
        scenarioSteps.add(new ScenarioCreateTrainStep(scenarioId, 0, "2E1234", "FL-FLV"));
        scenarioSteps.add(new ScenarioActionStep(scenarioId, 1, START_TRAIN));
        scenarioSteps.add(new ScenarioActionStep(scenarioId, 2, SET_SPEED_TO_SLOW));
        scenarioSteps.add(new ScenarioActionStep(scenarioId, 7, STOP_TRAIN));
        scenarioSteps.add(new ScenarioActionStep(scenarioId, 12, START_TRAIN));
        scenarioSteps.add(new ScenarioActionStep(scenarioId, 13, SET_SPEED_TO_FAST));
        scenarioSteps.add(new ScenarioActionStep(scenarioId, 22, ADD_DELAY));
        scenarioSteps.add(new ScenarioActionStep(scenarioId, 35, SET_SPEED_TO_NORMAL));
        for (ScenarioStep scenarioStep : scenarioSteps) {
            scenarioStepRepository.save(scenarioStep);
        }
    }

    public Optional<Scenario> find(UUID scenarioId) {
        return scenarioRepository.findById(scenarioId);
    }

    public List<ScenarioStep> findScenarioSteps(UUID scenarioId) {
        return scenarioStepRepository.findByScenarioId(scenarioId);
    }
}
