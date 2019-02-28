package com.bxy.cassandra.db;

import com.bxy.cassandra.scenario.ScenarioStep;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ScenarioStepRepositoryCassandraImpl {

    @PersistenceContext
    private EntityManager entityManger;

    public List<ScenarioStep> findByScenarioId(Long scenarioId) {
        return entityManger
                .createQuery("select s from ScenarioStep s where s.scenario.id = :scenarioId", ScenarioStep.class)
                .setParameter("scenarioId", scenarioId)
                .getResultList();
    }

    public void save(ScenarioStep scenarioStep) {
        entityManger.persist(scenarioStep);
        entityManger.flush();
    }

    public void saveAll(List<ScenarioStep> scenarioSteps) {
        for(ScenarioStep scenarioStep : scenarioSteps) {
            save(scenarioStep);
        }
    }

}
