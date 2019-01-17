package com.bxy.domain;

import java.util.List;

public interface ScenarioRepository {

    List<String> findAll();

    void add(Scenario scenario);
}
