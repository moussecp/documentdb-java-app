package com.bxy.cassandra.scenario;

import com.bxy.domain.Action;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "SCENARIO_ACTION_STEP")
public class ScenarioActionStep extends ScenarioStep {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ACTION")
    private Action action;

    public ScenarioActionStep() {
    }

    public ScenarioActionStep(Scenario scenario, int triggerTime, Action action) {
        super(scenario, triggerTime);
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
