package com.bxy.mariadb.scenario;

import com.bxy.domain.Action;
import com.bxy.domain.ScenarioStep;
import com.bxy.mariadb.db.ScenarioRepositoryMariadb;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioServiceMariadb {

    @Autowired
    private ScenarioRepositoryMariadb scenarioRepository;

    public void add(ScenarioMariadbDTO scenario) {
        scenarioRepository.save(scenario);
    }

    public List<ScenarioMariadbDTO> findAll() {
        return Lists.newArrayList(scenarioRepository.findAll());
    }

//    public ScenarioMariadbDTO createSimpleScenario(String name) {
//        return scenarioRepository.save(new ScenarioMariadbDTO(getCurrentScenarioId(), name, "BXY", LocalDateTime.now(), getScenarioSteps()));
//    }

    public ScenarioMariadbDTO createSimpleScenario(String name) {
        return scenarioRepository.save(new ScenarioMariadbDTO(name, "BXY", LocalDateTime.now(), getScenarioSteps()));
    }

    private String getCurrentScenarioId() {
        return String.valueOf(scenarioRepository.count() + 1);
    }

    public List<ScenarioMariadbDTO> generateScenarios(int numberOfScenarios) {
        List<ScenarioMariadbDTO> scenarios = new ArrayList<>();
        for(int i = 0; i<numberOfScenarios; i++) {
            scenarios.add(createSimpleScenario("scenario-number-" + i));
        }
        return scenarios;
    }

//    private List<String> getScenarioSteps() {
//        List<String> scenarioSteps = new ArrayList<>();
//        scenarioSteps.add(Action.START_TRAIN.name());
//        scenarioSteps.add(Action.SET_SPEED_TO_SLOW.name());
//        scenarioSteps.add(Action.STOP_TRAIN.name());
//        scenarioSteps.add(Action.START_TRAIN.name());
//        scenarioSteps.add(Action.SET_SPEED_TO_FAST.name());
//        scenarioSteps.add(Action.ADD_DELAY.name());
//        scenarioSteps.add(Action.SET_SPEED_TO_NORMAL.name());
//        return scenarioSteps;
//    }

    private List<ScenarioStepMariadbDTO> getScenarioSteps() {
        List<ScenarioStepMariadbDTO> scenarioSteps = new ArrayList<>();
        scenarioSteps.add(new ScenarioStepMariadbDTO(Action.START_TRAIN, 1));
        scenarioSteps.add(new ScenarioStepMariadbDTO(Action.SET_SPEED_TO_SLOW, 2));
        scenarioSteps.add(new ScenarioStepMariadbDTO(Action.STOP_TRAIN, 5));
        scenarioSteps.add(new ScenarioStepMariadbDTO(Action.START_TRAIN, 7));
        scenarioSteps.add(new ScenarioStepMariadbDTO(Action.SET_SPEED_TO_FAST, 8));
        scenarioSteps.add(new ScenarioStepMariadbDTO(Action.ADD_DELAY, 11));
        scenarioSteps.add(new ScenarioStepMariadbDTO(Action.SET_SPEED_TO_NORMAL, 15));
        return scenarioSteps;
    }
}
