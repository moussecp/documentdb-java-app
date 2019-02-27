package com.bxy.cassandra.scenario;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Table("SCENARIO")
public class Scenario {

    @PrimaryKey
    private UUID id;
    @Column
    private String name;
    @Column
    private String author;
    @Column("CREATION_DATE")
    private LocalDateTime creationDate;

    public Scenario() {
    }

    public Scenario(String name, String author, LocalDateTime creationDate) {
        this.id = UUIDs.timeBased();
        this.name = name;
        this.author = author;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
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

    @Override public String toString() {
        return "ModelScenario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scenario that = (Scenario) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAuthor(), that.getAuthor()) &&
                Objects.equals(getCreationDate(), that.getCreationDate());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor(), getCreationDate());
    }
}
