package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.StuffService;
import nl.kaiherwijn.pruntilo.dto.asListItem.StuffAsListitem;
import nl.kaiherwijn.pruntilo.dto.asSubject.StuffAsSubject;
import nl.kaiherwijn.pruntilo.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StuffEndpoint {

    @Autowired
    StuffService service;

    @GetMapping("stuff/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<StuffAsSubject> getStuffById(@PathVariable Long id) {
        return service.findStuffById(id).map(stuff -> new ResponseEntity<>(new StuffAsSubject(stuff), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("stuff")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<List<StuffAsListitem>> getStuffList() {
        return new ResponseEntity<>(service.findAllStuff().stream().map(StuffAsListitem::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("stuff")
    @ResponseStatus(HttpStatus.CREATED)
    public Stuff addStuff(@RequestBody @Valid Stuff stuff) {
        return service.addStuff(stuff);
    }

    @GetMapping("countactiveStuff/{year}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int countactiveStuff(@PathVariable int year) {
        return service.findAllStuff().stream().filter(
                stuff -> stuff.getLoanings().stream().filter(loaning -> loaning.getTook().getYear() == year).count() > 0
        ).collect(Collectors.toList()).size();
    }
}