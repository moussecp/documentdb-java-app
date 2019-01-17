package com.bxy.domain;

import java.util.Objects;

public class ScenarioStep {

    private Action action;
    private int actionTriggerTime;

    public ScenarioStep() {
    }

    public ScenarioStep(Action action, int actionTriggerTime) {
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
        ScenarioStep that = (ScenarioStep) o;
        return actionTriggerTime == that.actionTriggerTime &&
                action == that.action;
    }

    @Override public int hashCode() {
        return Objects.hash(action, actionTriggerTime);
    }

    @Override public String toString() {
        return "ScenarioStep{" +
                "action=" + action +
                ", actionTriggerTime=" + actionTriggerTime +
                '}';
    }
}
