package com.bxy.cassandra.db;

import com.bxy.cassandra.scenario.Scenario;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;
import java.util.UUID;

public interface ScenarioRepositoryCassandra extends CassandraRepository<Scenario, String> {

    Optional<Scenario> findById(UUID id);

}
