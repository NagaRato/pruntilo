package nl.kaiherwijn.pruntilo.controller;

import nl.kaiherwijn.pruntilo.model.Loaning;
import nl.kaiherwijn.pruntilo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoaningService {

    @Autowired
    private LoaningRepository repository;

    public List<Loaning> findAllLoanings() {
        return repository.findAll();
    }
}
