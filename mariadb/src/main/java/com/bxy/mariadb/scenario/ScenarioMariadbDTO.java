package com.bxy.mariadb.scenario;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "SCENARIO")
public class ScenarioMariadbDTO {

    @Id
    @Column(name = "SCENARIO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;
    @OneToMany//(mappedBy="scenarioId")
    @Column(name = "FK_SCENARIO_STEPS")
    private List<ScenarioStepMariadbDTO> scenarioSteps;

    public ScenarioMariadbDTO() {
    }

    public ScenarioMariadbDTO(String name, String author, LocalDateTime creationDate,
            List<ScenarioStepMariadbDTO> scenarioSteps) {
        this.name = name;
        this.author = author;
        this.creationDate = creationDate;
        this.scenarioSteps = scenarioSteps;
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

    public List<ScenarioStepMariadbDTO> getScenarioSteps() {
        return scenarioSteps;
    }

    public void setScenarioSteps(List<ScenarioStepMariadbDTO> scenarioSteps) {
        this.scenarioSteps = scenarioSteps;
    }
}
