package com.bxy.mongodb.scenario;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "scenario")
public class ScenarioMongoDTO {

    @Id
    private String id;

    private String name;
    private String author;
    private LocalDateTime creationDate;
    private List<String> scenarioSteps;

    public ScenarioMongoDTO() {
    }

    public ScenarioMongoDTO(String id, String name, String author, LocalDateTime creationDate,
            List<String> scenarioSteps) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.creationDate = creationDate;
        this.scenarioSteps = scenarioSteps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<String> getScenarioSteps() {
        return scenarioSteps;
    }

    public void setScenarioSteps(List<String> scenarioSteps) {
        this.scenarioSteps = scenarioSteps;
    }
}
