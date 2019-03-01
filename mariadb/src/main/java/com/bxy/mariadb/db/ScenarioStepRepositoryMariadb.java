package com.bxy.mariadb.db;

import com.bxy.mariadb.scenario.ScenarioStep;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScenarioStepRepositoryMariadb extends CrudRepository<ScenarioStep, Long> {

    List<ScenarioStep> findByScenarioId(Long scenarioId);
}
