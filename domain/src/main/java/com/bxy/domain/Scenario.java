package com.bxy.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Scenario {

    private String name;
    private String author;
    private LocalDateTime creationDate;
    private List<ScenarioStep> scenarioSteps;

    public Scenario() {
    }

    public Scenario(String name, String author, LocalDateTime creationDate,
            List<ScenarioStep> scenarioSteps) {
        this.name = name;
        this.author = author;
        this.creationDate = creationDate;
        this.scenarioSteps = scenarioSteps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<ScenarioStep> getScenarioSteps() {
        return scenarioSteps;
    }

    public void setScenarioSteps(List<ScenarioStep> scenarioSteps) {
        this.scenarioSteps = scenarioSteps;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scenario scenario = (Scenario) o;
        return Objects.equals(getName(), scenario.getName()) &&
                Objects.equals(getAuthor(), scenario.getAuthor()) &&
                Objects.equals(getCreationDate(), scenario.getCreationDate()) &&
                Objects.equals(getScenarioSteps(), scenario.getScenarioSteps());
    }

    @Override public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getCreationDate(), getScenarioSteps());
    }

    @Override public String toString() {
        return "Scenario{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", scenarioSteps=" + scenarioSteps +
                '}';
    }
}
