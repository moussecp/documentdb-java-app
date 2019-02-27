package com.bxy.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScenarioFactory {

    public ModelScenario createScenario(String name, String author, List<ModelScenarioStep> scenarioSteps) {
        return getBuilder()
                .withName(name)
                .withAuthor(author)
                .withScenarioSteps(scenarioSteps)
                .build();
    }

    public static ScenarioBuilder getBuilder() {
        return new ScenarioBuilder();
    }

    private static final class ScenarioBuilder {

        private ScenarioBuilder() {
        }

        private String name;
        private String author;
        private List<ModelScenarioStep> scenarioSteps;

        public ScenarioBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ScenarioBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public ScenarioBuilder withScenarioSteps(List<ModelScenarioStep> scenarioSteps) {
            this.scenarioSteps = scenarioSteps;
            return this;
        }

        public ModelScenario build() {
            return new ModelScenario(name, author, LocalDateTime.now(), scenarioSteps);
        }
    }
}
