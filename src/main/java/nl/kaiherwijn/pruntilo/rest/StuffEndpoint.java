package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.StuffService;
import nl.kaiherwijn.pruntilo.dto.asSubject.StuffAsSubject;
import nl.kaiherwijn.pruntilo.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StuffEndpoint {

    @Autowired
    StuffService service;

    @GetMapping("stuff/{id}")
    public @ResponseBody ResponseEntity<StuffAsSubject> getStuffById(@PathVariable Long id) {
        Optional<Stuff> stuffSimple = service.findStuffById(id);

        if (stuffSimple.isPresent()) {
            return new ResponseEntity<>(new StuffAsSubject(stuffSimple.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("stuff")
    public @ResponseBody ResponseEntity<List<StuffAsSubject>> getStuffList() {
        List<StuffAsSubject> stuffSimpleList = service.findAllStuff().stream().map(s->new StuffAsSubject(s)).collect(Collectors.toList());

        return new ResponseEntity<>(stuffSimpleList, HttpStatus.OK);
    }
}