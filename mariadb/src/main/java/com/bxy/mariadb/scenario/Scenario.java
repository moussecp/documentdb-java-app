package com.bxy.mariadb.scenario;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SCENARIO")
public class Scenario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "scenario")
    private List<ScenarioStep> scenarioSteps;

    public Scenario() {
    }

    public Scenario(String name, String author, LocalDateTime creationDate) {
        this.name = name;
        this.author = author;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAuthor(String author) {
        this.author = author;
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
        return Objects.equals(getId(), scenario.getId()) &&
                Objects.equals(getName(), scenario.getName()) &&
                Objects.equals(getAuthor(), scenario.getAuthor()) &&
                Objects.equals(getCreationDate(), scenario.getCreationDate()) &&
                Objects.equals(getScenarioSteps(), scenario.getScenarioSteps());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor(), getCreationDate(), getScenarioSteps());
    }

    @Override public String toString() {
        return "Scenario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", scenarioSteps=" + scenarioSteps +
                '}';
    }
}
