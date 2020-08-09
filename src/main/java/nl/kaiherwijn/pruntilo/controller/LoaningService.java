package nl.kaiherwijn.pruntilo.controller;

import nl.kaiherwijn.pruntilo.exceptions.ConflictException;
import nl.kaiherwijn.pruntilo.model.Loaning;
import nl.kaiherwijn.pruntilo.model.Member;
import nl.kaiherwijn.pruntilo.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoaningService {

    @Autowired
    private LoaningRepository repository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private StuffService stuffService;

    public Optional<Loaning> findLoaningById(Long id) {
        return repository.findById(id);
    }

    public List<Loaning> findAllLoanings() {
        return repository.findAll();
    }

    public Loaning addLoaning(Loaning loaning) {
        if (loaning.getTake() == null) {
            throw new ConflictException("Because there is no takedate, the loaning could not be added.");
        }
        Optional<Member> memberOfLoangingToAdd = memberService.findMemberById(loaning.getMemberId());
        if (memberOfLoangingToAdd.isPresent()) {
            loaning.setMember(memberOfLoangingToAdd.get());
        }
        else {
            throw new ConflictException("Because there is no member with id " + loaning.getMemberId() + ", the loaning could not be added.");
        }
        Optional<Stuff> stuffOfLoangingToAdd = stuffService.findStuffById(loaning.getStuffId());
        if (stuffService.findStuffById(loaning.getStuffId()).isPresent()) {
            loaning.setStuff(stuffOfLoangingToAdd.get());
        }
        else {
            throw new ConflictException("Because there is no stuff with id " + loaning.getStuffId() + ", the loaning could not be added.");
        }
        if (loaning.getBring() != null && loaning.getBring().isBefore(loaning.getTake())) {
            throw new ConflictException("Because bringdate is before the takedate, the loaning could not be added.");
        }
        return repository.save(loaning);
    }
}
