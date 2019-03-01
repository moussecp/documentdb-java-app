package com.bxy.mariadb.scenario;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CREATE_TRAIN_STEP")
public class ScenarioCreateTrainStep extends ScenarioStep {

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

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getMovementLine() {
        return movementLine;
    }

    public void setMovementLine(String movementLine) {
        this.movementLine = movementLine;
    }

}
