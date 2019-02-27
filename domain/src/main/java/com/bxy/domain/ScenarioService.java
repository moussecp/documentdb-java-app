package com.bxy.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public abstract class ScenarioService {

    @Autowired
    private ScenarioFactory scenarioFactory;
    @Autowired
    private ScenarioStepFactory scenarioStepFactory;


    public ModelScenario createSimpleScenario(String name) {
        ModelScenario scenario = scenarioFactory.createScenario(name, "BXY", getSimpleScenarioSteps());
        add(scenario);
        return scenario;
    }

    public abstract void add(ModelScenario scenario);

    private List<ModelScenarioStep> getSimpleScenarioSteps() {
        List<ModelScenarioStep> scenarioSteps = new ArrayList<>();
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

    public List<ModelScenario> generateScenarios(int numberOdScenarios) {
        List<ModelScenario> scenarios = new ArrayList<>();
        for (int i = 0; i < numberOdScenarios; i++) {
            scenarios.add(createSimpleScenario("generated" + i));
        }
        return scenarios;
    }
}
