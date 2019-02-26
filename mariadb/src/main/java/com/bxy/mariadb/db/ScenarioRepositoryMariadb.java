package com.bxy.mariadb.db;

import com.bxy.mariadb.scenario.ScenarioMariadbDTO;
import org.springframework.data.repository.CrudRepository;


public interface ScenarioRepositoryMariadb extends CrudRepository<ScenarioMariadbDTO, String> {


}
