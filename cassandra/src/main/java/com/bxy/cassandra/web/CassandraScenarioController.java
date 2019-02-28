package com.bxy.cassandra.web;

import com.bxy.cassandra.scenario.ScenarioServiceCassandra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/cassandra")
public class CassandraScenarioController {

    @Autowired
    private ScenarioServiceCassandra scenarioService;

    @RequestMapping(value = "/scenario/findAll", method = GET)
    public ResponseEntity findAllScenarios() {
        return ResponseEntity.ok(scenarioService.findAll());
    }

    @RequestMapping(value = "/scenario/find/{scenarioId}", method = GET)
    public ResponseEntity findScenario(@PathVariable Long scenarioId) {
        return ResponseEntity.ok(scenarioService.find(scenarioId));
    }

    @RequestMapping(value = "/scenariosteps/find/{scenarioId}", method = GET)
    public ResponseEntity findScenarioSteps(@PathVariable Long scenarioId) {
        return ResponseEntity.ok(scenarioService.findScenarioSteps(scenarioId));
    }

    @RequestMapping(value = "/scenario/addNew/{name}", method = POST)
    public ResponseEntity addNew(@PathVariable String name) {
        return ResponseEntity.ok(scenarioService.createSimpleScenario(name));
    }

    @RequestMapping(value = "/scenario/generate", method = GET)
    public ResponseEntity generate() {
        return ResponseEntity.ok(scenarioService.generateScenarios(100));
    }

}
