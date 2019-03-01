package com.bxy.mariadb.scenario;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "SCENARIO_STEP")
@DiscriminatorColumn(name = "TYPE")
public abstract class ScenarioStep {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
