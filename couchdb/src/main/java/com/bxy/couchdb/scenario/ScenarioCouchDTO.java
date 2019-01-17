package com.bxy.couchdb.scenario;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.ektorp.support.CouchDbDocument;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ScenarioCouchDTO extends CouchDbDocument {

    private String name;
    private String author;
    private LocalDateTime creationDate;
    private List<ScenarioStepCouchDTO> scenarioSteps;

    public ScenarioCouchDTO() {
    }

    public ScenarioCouchDTO(String name, String author, LocalDateTime creationDate,
            List<ScenarioStepCouchDTO> scenarioSteps) {
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

    @JsonProperty("creation_date")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creation_date")
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<ScenarioStepCouchDTO> getScenarioSteps() {
        return scenarioSteps;
    }

    public void setScenarioSteps(List<ScenarioStepCouchDTO> scenarioSteps) {
        this.scenarioSteps = scenarioSteps;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScenarioCouchDTO scenario = (ScenarioCouchDTO) o;
        return Objects.equals(getName(), scenario.getName()) &&
                Objects.equals(getAuthor(), scenario.getAuthor()) &&
                Objects.equals(getCreationDate(), scenario.getCreationDate()) &&
                Objects.equals(getScenarioSteps(), scenario.getScenarioSteps());
    }

    @Override public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getCreationDate(), getScenarioSteps());
    }

    @Override public String toString() {
        return "ScenarioCouchDTO{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", scenarioSteps=" + scenarioSteps +
                '}';
    }
}
