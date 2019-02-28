package com.bxy.cassandra.scenario;

import javax.persistence.*;

@Entity
@Table(name = "SCENARIO_CREATE_TRAIN_STEP")
public class ScenarioCreateTrainStep extends ScenarioStep {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TRAIN_NUMBER")
    private String trainNumber;

    @Column(name = "MOVEMENT_LINE")
    private String movementLine;

    public ScenarioCreateTrainStep() {
    }

    public ScenarioCreateTrainStep(Scenario scenario, int triggerTime, String trainNumber, String movementLine) {
        super(scenario, triggerTime);
        this.trainNumber = trainNumber;
        this.movementLine = movementLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getMovementLine() {
        return movementLine;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setMovementLine(String movementLine) {
        this.movementLine = movementLine;
    }

}
