package com.bxy.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ModelScenario {

    private String name;
    private String author;
    private LocalDateTime creationDate;
    private List<ModelScenarioStep> scenarioSteps;

    public ModelScenario() {
    }

    public ModelScenario(String name, String author, LocalDateTime creationDate,
                         List<ModelScenarioStep> scenarioSteps) {
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

    public List<ModelScenarioStep> getScenarioSteps() {
        return scenarioSteps;
    }

    public void setScenarioSteps(List<ModelScenarioStep> scenarioSteps) {
        this.scenarioSteps = scenarioSteps;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelScenario scenario = (ModelScenario) o;
        return Objects.equals(getName(), scenario.getName()) &&
                Objects.equals(getAuthor(), scenario.getAuthor()) &&
                Objects.equals(getCreationDate(), scenario.getCreationDate()) &&
                Objects.equals(getScenarioSteps(), scenario.getScenarioSteps());
    }

    @Override public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getCreationDate(), getScenarioSteps());
    }

    @Override public String toString() {
        return "ModelScenario{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", scenarioSteps=" + scenarioSteps +
                '}';
    }
}
