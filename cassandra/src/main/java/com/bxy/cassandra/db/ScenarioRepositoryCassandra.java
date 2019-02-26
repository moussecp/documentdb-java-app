package com.bxy.cassandra.db;

import com.bxy.cassandra.scenario.ScenarioCassandraDTO;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScenarioRepositoryCassandra extends CrudRepository<ScenarioCassandraDTO, String> {

    @AllowFiltering
    public Optional<ScenarioCassandraDTO> findById(UUID id);

    @AllowFiltering
    public List<ScenarioCassandraDTO> findByAuthor(String author);

    @AllowFiltering
    public List<ScenarioCassandraDTO> findByNameContaining(String name);

}
