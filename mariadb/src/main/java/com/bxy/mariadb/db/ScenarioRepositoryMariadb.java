package com.bxy.mariadb.db;

import com.bxy.mariadb.scenario.Scenario;
import org.springframework.data.repository.CrudRepository;

public interface ScenarioRepositoryMariadb extends CrudRepository<Scenario, String> {

}
