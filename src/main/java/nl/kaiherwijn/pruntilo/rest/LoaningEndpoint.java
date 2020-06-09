package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.LoaningService;
import nl.kaiherwijn.pruntilo.dto.asSubject.LoaningAsSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoaningEndpoint {

    @Autowired
    LoaningService loaningService;

    @GetMapping("loaning")
    public @ResponseBody
    ResponseEntity<List<LoaningAsSubject>> getLoaningList() {
        List<LoaningAsSubject> listLoaningSimple = loaningService.findAllLoanings().stream().map(l -> new LoaningAsSubject(l)).collect(Collectors.toList());
        return new ResponseEntity<List<LoaningAsSubject>>(listLoaningSimple, HttpStatus.OK);
    }
}
