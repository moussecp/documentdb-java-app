package com.bxy.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScenarioFactory {

    public Scenario createScenario(String name, String author, List<ScenarioStep> scenarioSteps) {
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
        private List<ScenarioStep> scenarioSteps;

        public ScenarioBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ScenarioBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public ScenarioBuilder withScenarioSteps(List<ScenarioStep> scenarioSteps) {
            this.scenarioSteps = scenarioSteps;
            return this;
        }

        public Scenario build() {
            return new Scenario(name, author, LocalDateTime.now(), scenarioSteps);
        }
    }
}
