package com.bxy.cassandra.db;

import com.bxy.cassandra.scenario.ScenarioStep;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ScenarioStepRepositoryCassandra extends CassandraRepository<ScenarioStep, String> {

    List<ScenarioStep> findByScenarioId(UUID scenarioId);

}
