package com.bxy.couchdb.scenario;

import com.bxy.domain.Action;
import org.ektorp.support.CouchDbDocument;

import java.util.Objects;

public class ScenarioStepCouchDTO extends CouchDbDocument {

    private Action action;
    private int actionTriggerTime;

    public ScenarioStepCouchDTO() {
    }

    public ScenarioStepCouchDTO(Action action, int actionTriggerTime) {
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

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScenarioStepCouchDTO that = (ScenarioStepCouchDTO) o;
        return actionTriggerTime == that.actionTriggerTime &&
                action == that.action;
    }

    @Override public int hashCode() {
        return Objects.hash(action, actionTriggerTime);
    }

    @Override public String toString() {
        return "ScenarioStepCouchDTO{" +
                "action=" + action +
                ", actionTriggerTime=" + actionTriggerTime +
                '}';
    }
}
