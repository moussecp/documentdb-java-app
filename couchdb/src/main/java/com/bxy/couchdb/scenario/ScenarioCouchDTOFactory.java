package com.bxy.couchdb.scenario;

import com.bxy.domain.Scenario;
import com.bxy.domain.ScenarioStep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScenarioCouchDTOFactory {

    public ScenarioCouchDTO convertScenario(Scenario scenario) {
        return new ScenarioCouchDTO(scenario.getName(), scenario.getAuthor(), scenario.getCreationDate(),
                convertEachScenarioSteps(scenario.getScenarioSteps()));
    }

    public List<ScenarioStepCouchDTO> convertEachScenarioSteps(List<ScenarioStep> scenarioSteps) {
        return scenarioSteps.stream()
                .map(scenarioStep -> convertScenarioStep(scenarioStep))
                .collect(Collectors.toList());
    }

    public ScenarioStepCouchDTO convertScenarioStep(ScenarioStep scenarioStep) {
        return new ScenarioStepCouchDTO(scenarioStep.getAction(), scenarioStep.getActionTriggerTime());
    }
}
