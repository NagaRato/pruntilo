package nl.kaiherwijn.pruntilo.controller;

import nl.kaiherwijn.pruntilo.model.Loaning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoaningService {

    @Autowired
    private LoaningRepository repository;

    public Optional<Loaning> findLoaningById(Long id) {
        return repository.findById(id);
    }

    public List<Loaning> findAllLoanings() {
        return repository.findAll();
    }
}
