package com.bxy.cassandra.db;

import com.bxy.cassandra.scenario.Scenario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ScenarioRepositoryCassandraImpl {

    @PersistenceContext
    private EntityManager entityManger;

    public List<Scenario> findAll() {
        return entityManger.createQuery("select s from Scenario s", Scenario.class).getResultList();
    }

    public Scenario save(Scenario scenario) {
        entityManger.persist(scenario);
        entityManger.flush();
        return scenario;
    }

    public Scenario findById(Long scenarioId) {
        return entityManger.find(Scenario.class, scenarioId);
    }
}
