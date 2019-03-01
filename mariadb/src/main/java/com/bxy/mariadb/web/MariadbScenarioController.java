package com.bxy.mariadb.web;

import com.bxy.mariadb.scenario.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/mariadb")
public class MariadbScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @RequestMapping(value = "/scenario/findAll", method = GET)
    public ResponseEntity findAllScenarios() {
        return ResponseEntity.ok(scenarioService.findAll());
    }

    @RequestMapping(value = "/scenario/addNew/{name}", method = POST)
    public ResponseEntity addNew(@PathVariable String name) {
        return ResponseEntity.ok(scenarioService.createSimpleScenario(name));
    }

    @RequestMapping(value = "/scenario/generate", method = GET)
    public ResponseEntity generate() {
        return ResponseEntity.ok(scenarioService.generateScenarios(100));
    }

    @RequestMapping(value = "/scenariosteps/find/{scenarioId}", method = GET)
    public ResponseEntity findScenarioSteps(@PathVariable Long scenarioId) {
        return ResponseEntity.ok(scenarioService.findScenarioSteps(scenarioId));
    }

}
