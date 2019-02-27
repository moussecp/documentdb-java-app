package com.bxy.cassandra.scenario;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Table("SCENARIO_CREATE_TRAIN_STEP")
public class ScenarioCreateTrainStep extends ScenarioStep {

    @Column("TRAIN_NUMBER")
    private String trainNumber;
    @Column("MOVEMENT_LINE")
    private String movementLine;

    public ScenarioCreateTrainStep() {
    }

    public ScenarioCreateTrainStep(UUID scenarioId, int triggerTime, String trainNumber, String movementLine) {
        super(scenarioId, triggerTime);
        this.trainNumber = trainNumber;
        this.movementLine = movementLine;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getMovementLine() {
        return movementLine;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ScenarioCreateTrainStep.class.getSimpleName() + "[", "]")
                .add("trainNumber='" + trainNumber + "'")
                .add("movementLine='" + movementLine + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScenarioCreateTrainStep that = (ScenarioCreateTrainStep) o;
        return Objects.equals(trainNumber, that.trainNumber) &&
                Objects.equals(movementLine, that.movementLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trainNumber, movementLine);
    }
}
