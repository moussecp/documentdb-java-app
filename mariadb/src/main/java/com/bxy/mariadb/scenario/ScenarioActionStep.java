package com.bxy.mariadb.scenario;

import com.bxy.domain.Action;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@DiscriminatorValue("ACTION_STEP")
public class ScenarioActionStep extends ScenarioStep {

    @Column(name = "ACTION")
    private Action action;

    public ScenarioActionStep() {
    }

    public ScenarioActionStep(Scenario scenario, int triggerTime, Action action) {
        super(scenario, triggerTime);
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
