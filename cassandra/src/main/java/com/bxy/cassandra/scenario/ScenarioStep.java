package com.bxy.cassandra.scenario;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.Objects;
import java.util.UUID;

public abstract class ScenarioStep {

    @PrimaryKey
    @Column("ID")
    private UUID id;
    @Column("TRIGGER_TIME")
    private int triggerTime;
    @Column("SCENARIO_ID")
    private UUID scenarioId;

    public ScenarioStep() {
    }

    public ScenarioStep(UUID scenarioId, int triggerTime) {
        this.id = UUIDs.timeBased();
        this.scenarioId = scenarioId;
        this.triggerTime = triggerTime;
    }

    public int getTriggerTime() {
        return triggerTime;
    }

    public UUID getId() {
        return id;
    }

    public UUID getScenarioId() {
        return scenarioId;
    }

    @Override
    public String toString() {
        return "ScenarioStep{" +
                "id=" + id +
                ", triggerTime=" + triggerTime +
                ", scenarioId=" + scenarioId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScenarioStep that = (ScenarioStep) o;
        return getTriggerTime() == that.getTriggerTime() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getScenarioId(), that.getScenarioId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTriggerTime(), getScenarioId());
    }
}
