package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.LoaningService;
import nl.kaiherwijn.pruntilo.dto.asListItem.LoaningAsListitem;
import nl.kaiherwijn.pruntilo.dto.asSubject.LoaningAsSubject;
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
public class LoaningEndpoint {

    @Autowired
    LoaningService service;

    @GetMapping("loaning/{id}")
    public @ResponseBody
    ResponseEntity<LoaningAsSubject> getLoaningById(@PathVariable Long id) {
        return service.findLoaningById(id).map(value -> new ResponseEntity<>(new LoaningAsSubject(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("loaning")
    public @ResponseBody
    ResponseEntity<List<LoaningAsListitem>> getLoaningList() {
        List<LoaningAsListitem> listLoaningSimple = service.findAllLoanings().stream().map(LoaningAsListitem::new).collect(Collectors.toList());
        return new ResponseEntity<>(listLoaningSimple, HttpStatus.OK);
    }
}
