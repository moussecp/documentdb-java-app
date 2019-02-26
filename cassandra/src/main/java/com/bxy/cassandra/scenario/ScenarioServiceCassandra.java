package com.bxy.cassandra.scenario;

import com.bxy.cassandra.db.ScenarioRepositoryCassandra;
import com.bxy.cassandra.db.ScenarioStepRepositoryCassandra;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.bxy.domain.Action.*;

@Service
public class ScenarioServiceCassandra {

    @Autowired
    private ScenarioRepositoryCassandra scenarioRepository;
    @Autowired
    private ScenarioStepRepositoryCassandra scenarioStepRepository;

    public List<ScenarioCassandraDTO> findAll() {
        return Lists.newArrayList(scenarioRepository.findAll());
    }

    public ScenarioCassandraDTO createSimpleScenario(String name) {
        ScenarioCassandraDTO scenario = scenarioRepository
                .save(new ScenarioCassandraDTO(name, "BXY", LocalDateTime.now()));
        createScenarioSteps(scenario);
        return scenario;
    }

    public List<ScenarioCassandraDTO> generateScenarios(int numberOfScenarios) {
        List<ScenarioCassandraDTO> scenarios = new ArrayList<>();
        for (int i = 0; i < numberOfScenarios; i++) {
            scenarios.add(createSimpleScenario("scenario-number-" + i));
        }
        return scenarios;
    }

    private void createScenarioSteps(ScenarioCassandraDTO scenario) {
        List<ScenarioStepCassandraDTO> scenarioSteps = new ArrayList<>();
        UUID scenarioId = scenario.getId();
        scenarioSteps.add(new ScenarioStepCassandraDTO(scenarioId, START_TRAIN, 1));
        scenarioSteps.add(new ScenarioStepCassandraDTO(scenarioId, SET_SPEED_TO_SLOW, 2));
        scenarioSteps.add(new ScenarioStepCassandraDTO(scenarioId, STOP_TRAIN, 5));
        scenarioSteps.add(new ScenarioStepCassandraDTO(scenarioId, START_TRAIN, 7));
        scenarioSteps.add(new ScenarioStepCassandraDTO(scenarioId, SET_SPEED_TO_FAST, 10));
        scenarioSteps.add(new ScenarioStepCassandraDTO(scenarioId, ADD_DELAY, 15));
        scenarioSteps.add(new ScenarioStepCassandraDTO(scenarioId, SET_SPEED_TO_NORMAL, 35));
        for (ScenarioStepCassandraDTO scenarioStep : scenarioSteps) {
            scenarioStepRepository.save(scenarioStep);
        }
    }

    public Optional<ScenarioCassandraDTO> find(UUID scenarioId) {
        return scenarioRepository.findById(scenarioId);
    }

    public List<ScenarioStepCassandraDTO> findScenarioSteps(UUID scenarioId) {
        return scenarioStepRepository.findByScenarioIdOrderByActionTriggerTime(scenarioId);
    }
}
