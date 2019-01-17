package com.bxy.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public abstract class ScenarioService {

    @Autowired
    private ScenarioFactory scenarioFactory;
    @Autowired
    private ScenarioStepFactory scenarioStepFactory;


    public Scenario createSimpleScenario(String name) {
        Scenario scenario = scenarioFactory.createScenario(name, "BXY", getSimpleScenarioSteps());
        add(scenario);
        return scenario;
    }

    public abstract void add(Scenario scenario);

    private List<ScenarioStep> getSimpleScenarioSteps() {
        List<ScenarioStep> scenarioSteps = new ArrayList<>();
        scenarioSteps.add(scenarioStepFactory.createScenarioStep(Action.START_TRAIN, 0));
        scenarioSteps.add(scenarioStepFactory.createScenarioStep(Action.SET_SPEED_TO_SLOW, 2));
        scenarioSteps.add(scenarioStepFactory.createScenarioStep(Action.STOP_TRAIN, 5));
        scenarioSteps.add(scenarioStepFactory.createScenarioStep(Action.START_TRAIN, 7));
        scenarioSteps.add(scenarioStepFactory.createScenarioStep(Action.SET_SPEED_TO_FAST, 10));
        scenarioSteps.add(scenarioStepFactory.createScenarioStep(Action.ADD_DELAY, 15));
        scenarioSteps.add(scenarioStepFactory.createScenarioStep(Action.SET_SPEED_TO_NORMAL, 20));
        return scenarioSteps;
    }

    public abstract List<String> findAll();

    public List<Scenario> generateScenarios(int numberOdScenarios) {
        List<Scenario> scenarios = new ArrayList<>();
        for (int i = 0; i < numberOdScenarios; i++) {
            scenarios.add(createSimpleScenario("generated" + i));
        }
        return scenarios;
    }
}
