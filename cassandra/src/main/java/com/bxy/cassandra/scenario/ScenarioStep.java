package com.bxy.cassandra.scenario;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ScenarioStep {

    @Column(name = "TRIGGER_TIME")
    private int triggerTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCENARIO_ID")
    private Scenario scenario;

    public ScenarioStep() {
    }

    public ScenarioStep(Scenario scenario, int triggerTime) {
        this.scenario = scenario;
        this.triggerTime = triggerTime;
    }

    public int getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(int triggerTime) {
        this.triggerTime = triggerTime;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

}
