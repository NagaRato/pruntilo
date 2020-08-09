package nl.kaiherwijn.pruntilo.controller;

import nl.kaiherwijn.pruntilo.exceptions.ConflictException;
import nl.kaiherwijn.pruntilo.model.Stuff;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StuffService {
    @Autowired
    private StuffRepository repository;

    public Optional<Stuff> findStuffById(Long id) {
        Optional<Stuff> stuffOptional = repository.findById(id);
        return stuffOptional;
    }

    public List<Stuff> findAllStuff() {
        return repository.findAll();
    }

    public Stuff addStuff(Stuff stuff) {
        if (stuff.getName().trim().length() < 1) {
            throw new ConflictException("The name of the stuff schould be at least one character long after trimming.");
        }
        stuff.setName(stuff.getName().trim());
        return repository.save(stuff);
    }
}
