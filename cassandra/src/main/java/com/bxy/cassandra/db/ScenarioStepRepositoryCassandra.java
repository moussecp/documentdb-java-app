package com.bxy.cassandra.db;

import com.bxy.cassandra.scenario.ScenarioStepCassandraDTO;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ScenarioStepRepositoryCassandra extends CrudRepository<ScenarioStepCassandraDTO, String> {

    @AllowFiltering
    public List<ScenarioStepCassandraDTO> findByScenarioIdOrderByActionTriggerTime(UUID scenarioId);

}
