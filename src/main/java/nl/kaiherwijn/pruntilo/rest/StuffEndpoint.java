package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.StuffService;
import nl.kaiherwijn.pruntilo.dto.asListItem.StuffAsListitem;
import nl.kaiherwijn.pruntilo.dto.asSubject.StuffAsSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StuffEndpoint {

    @Autowired
    StuffService service;

    @GetMapping("stuff/{id}")
    public @ResponseBody ResponseEntity<StuffAsSubject> getStuffById(@PathVariable Long id) {
        return service.findStuffById(id).map(stuff -> new ResponseEntity<>(new StuffAsSubject(stuff), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("stuff")
    public @ResponseBody ResponseEntity<List<StuffAsListitem>> getStuffList() {
        return new ResponseEntity<>(service.findAllStuff().stream().map(StuffAsListitem::new).collect(Collectors.toList()), HttpStatus.OK);
    }
}