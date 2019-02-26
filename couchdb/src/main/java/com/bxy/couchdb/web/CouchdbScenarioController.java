package com.bxy.couchdb.web;

import com.bxy.domain.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/couchdb")
public class CouchdbScenarioController {

    @Autowired
    @Qualifier("couchdbScenarioService")
    private ScenarioService scenarioService;

    @RequestMapping(value = "/findAll", method = GET)
    public ResponseEntity findAllScenarios() {
        return ResponseEntity.ok(scenarioService.findAll());
    }

    @RequestMapping(value = "/addNew/{name}", method = POST)
    public ResponseEntity addNew(@PathVariable String name) {
        return ResponseEntity.ok(scenarioService.createSimpleScenario(name));
    }

    @RequestMapping(value = "/generate", method = GET)
    public ResponseEntity generate() {
        return ResponseEntity.ok(scenarioService.generateScenarios(100));
    }

}
