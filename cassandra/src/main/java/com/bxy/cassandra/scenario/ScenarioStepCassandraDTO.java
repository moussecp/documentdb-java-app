package com.bxy.cassandra.scenario;

import com.bxy.domain.Action;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table("SCENARIO_STEP")
public class ScenarioStepCassandraDTO {

    @PrimaryKey
    private UUID id;
    @Column
    private Action action;
    @Column("TRIGGER_TIME")
    private int actionTriggerTime;
    @Column("SCENARIO")
    private UUID scenarioId;

    public ScenarioStepCassandraDTO() {
    }

    public ScenarioStepCassandraDTO(UUID scenarioId, Action action, int actionTriggerTime) {
        this.id = UUIDs.timeBased();
        this.scenarioId = scenarioId;
        this.action = action;
        this.actionTriggerTime = actionTriggerTime;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getActionTriggerTime() {
        return actionTriggerTime;
    }

    public void setActionTriggerTime(int actionTriggerTime) {
        this.actionTriggerTime = actionTriggerTime;
    }

    public UUID getId() {
        return id;
    }

    public UUID getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(UUID scenarioId) {
        this.scenarioId = scenarioId;
    }

    @Override public String toString() {
        return "ScenarioStepCassandraDTO{" +
                "id=" + id +
                ", action=" + action +
                ", actionTriggerTime=" + actionTriggerTime +
                ", scenarioId=" + scenarioId +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScenarioStepCassandraDTO that = (ScenarioStepCassandraDTO) o;
        return getActionTriggerTime() == that.getActionTriggerTime() &&
                Objects.equals(getId(), that.getId()) &&
                getAction() == that.getAction() &&
                Objects.equals(getScenarioId(), that.getScenarioId());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getAction(), getActionTriggerTime(), getScenarioId());
    }
}
