package com.bxy.domain;

import org.springframework.stereotype.Service;

@Service
public class ScenarioStepFactory {

    public ModelScenarioStep createScenarioStep(Action action, int actionTriggerTime) {
        return getBuilder()
                .withAction(action)
                .withTriggerTime(actionTriggerTime)
                .build();
    }

    public static ScenarioStepBuilder getBuilder() {
        return new ScenarioStepBuilder();
    }

    private static final class ScenarioStepBuilder {

        private ScenarioStepBuilder() {
        }

        private Action action;
        private int actionTriggerTime;

        public ScenarioStepBuilder withAction(Action action) {
            this.action = action;
            return this;
        }

        public ScenarioStepBuilder withTriggerTime(int actionTriggerTime) {
            this.actionTriggerTime = actionTriggerTime;
            return this;
        }

        public ModelScenarioStep build() {
            return new ModelScenarioStep(action, actionTriggerTime);
        }
    }
}
