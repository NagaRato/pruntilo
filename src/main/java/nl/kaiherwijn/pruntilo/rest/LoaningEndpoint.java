package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.LoaningService;
import nl.kaiherwijn.pruntilo.dto.asListItem.LoaningAsListitem;
import nl.kaiherwijn.pruntilo.dto.asSubject.LoaningAsSubject;
import nl.kaiherwijn.pruntilo.model.Loaning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class LoaningEndpoint {

    @Autowired
    LoaningService service;

    @GetMapping("loaning/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity<LoaningAsSubject> getLoaningById(@PathVariable Long id) {
        return service.findLoaningById(id).map(value -> new ResponseEntity<>(new LoaningAsSubject(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("loaning")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity<List<LoaningAsListitem>> getLoaningList() {
        List<LoaningAsListitem> listLoaningSimple = service.findAllLoanings().stream().map(LoaningAsListitem::new).collect(Collectors.toList());
        return new ResponseEntity<>(listLoaningSimple, HttpStatus.OK);
    }

    @PostMapping("loaningbegin")
    @ResponseStatus(HttpStatus.CREATED)
    public Loaning addLoaning(@RequestBody @Valid Loaning loaning) {
        return service.addLoaning(loaning);
    }

    @PutMapping("loaningfinish/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Loaning finishLoaning(@PathVariable Long id, @RequestBody @Valid Loaning loaning) {
        return service.finishLoaning(id, loaning.getStuffId());
    }

    @GetMapping("countLoaningsOfYear/{year}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int countLoaningsOfYear(@PathVariable int year) {
        return service.findAllLoanings().stream().filter(loaning -> loaning.getTook().getYear() == year).collect(Collectors.toList()).size();
    }

    @GetMapping("countLoaningsByYear")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<Integer, Integer> countLoaningsByYear() {
        return service.findAllLoanings().stream().collect(Collectors.groupingBy(loaning -> loaning.getTook().getYear(), Collectors.summingInt(e -> 1)));
    }
}
