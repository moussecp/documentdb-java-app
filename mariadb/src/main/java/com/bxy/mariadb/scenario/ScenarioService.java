package com.bxy.mariadb.scenario;

import com.bxy.mariadb.db.ScenarioRepositoryMariadb;
import com.bxy.mariadb.db.ScenarioStepRepositoryMariadb;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bxy.domain.Action.*;
import static java.time.LocalDateTime.now;

@Service
@Transactional
public class ScenarioService {

    @Autowired
    private ScenarioRepositoryMariadb scenarioRepository;
    @Autowired
    private ScenarioStepRepositoryMariadb scenarioStepRepository;

    public List<Scenario> findAll() {
        return Lists.newArrayList(scenarioRepository.findAll());
    }

    public Scenario createSimpleScenario(String name) {
        Scenario scenario = scenarioRepository.save(new Scenario(name, "BXY", now()));
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
        scenarioSteps.add(new ScenarioCreateTrainStep(scenario, 0, "2E1234", "FL-FLV"));
        scenarioSteps.add(new ScenarioActionStep(scenario, 1, START_TRAIN));
        scenarioSteps.add(new ScenarioActionStep(scenario, 2, SET_SPEED_TO_SLOW));
        scenarioSteps.add(new ScenarioActionStep(scenario, 7, STOP_TRAIN));
        scenarioSteps.add(new ScenarioActionStep(scenario, 12, START_TRAIN));
        scenarioSteps.add(new ScenarioActionStep(scenario, 13, SET_SPEED_TO_FAST));
        scenarioSteps.add(new ScenarioActionStep(scenario, 22, ADD_DELAY));
        scenarioSteps.add(new ScenarioActionStep(scenario, 35, SET_SPEED_TO_NORMAL));
        scenarioStepRepository.saveAll(scenarioSteps);
    }

    public Optional<Scenario> find(String scenarioId) {
        return scenarioRepository.findById(scenarioId);
    }

    public List<ScenarioStep> findScenarioSteps(Long scenarioId) {
        return scenarioStepRepository.findByScenarioId(scenarioId);
    }
}
