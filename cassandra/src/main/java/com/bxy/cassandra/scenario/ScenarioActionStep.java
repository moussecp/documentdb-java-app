package com.bxy.cassandra.scenario;

import com.bxy.domain.Action;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Table("SCENARIO_ACTION_STEP")
public class ScenarioActionStep extends ScenarioStep {

    @Column("ACTION")
    private Action action;

    public ScenarioActionStep() {
    }

    public ScenarioActionStep(UUID scenarioId, int triggerTime, Action action) {
        super(scenarioId, triggerTime);
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScenarioActionStep that = (ScenarioActionStep) o;
        return action == that.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), action);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ScenarioActionStep.class.getSimpleName() + "[", "]")
                .add("action=" + action)
                .toString();
    }
}
