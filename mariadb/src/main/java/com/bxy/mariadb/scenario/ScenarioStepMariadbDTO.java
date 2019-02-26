package com.bxy.mariadb.scenario;

import com.bxy.domain.Action;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SCENARIO_STEP")
public class ScenarioStepMariadbDTO  {

    @Id
    @Column(name = "SCENARIO_STEP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Action action;
    @Column(name = "ACTION_TRIGGER_TIME")
    private int actionTriggerTime;
//    @ManyToOne
//    @JoinColumn(name="SCENARIO_ID")
//    private Long scenarioId;

    public ScenarioStepMariadbDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getScenarioId() {
//        return scenarioId;
//    }
//
//    public void setScenarioId(Long scenarioId) {
//        this.scenarioId = scenarioId;
//    }

    public ScenarioStepMariadbDTO(Action action, int actionTriggerTime) {
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
        ScenarioStepMariadbDTO that = (ScenarioStepMariadbDTO) o;
        return actionTriggerTime == that.actionTriggerTime &&
                action == that.action;
    }

    @Override public int hashCode() {
        return Objects.hash(action, actionTriggerTime);
    }

    @Override public String toString() {
        return "ScenarioStepMariadbDTO{" +
                "action=" + action +
                ", actionTriggerTime=" + actionTriggerTime +
                '}';
    }
}
