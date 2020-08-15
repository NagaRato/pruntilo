package nl.kaiherwijn.pruntilo.controller;

import nl.kaiherwijn.pruntilo.dto.asListItem.StuffAsListitem;
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
        loaning.setTook(LocalDate.now());
        Optional<Member> memberOfLoangingToAdd = memberService.findMemberById(loaning.getMemberId());
        if (memberOfLoangingToAdd.isPresent()) {
            loaning.setMember(memberOfLoangingToAdd.get());
        }
        else {
            throw new ConflictException("Because there is no member with id " + loaning.getMemberId() + ", the loaning could not be added.");
        }
        Optional<Stuff> stuffOfLoangingToAdd = stuffService.findStuffById(loaning.getStuffId());
        if (stuffOfLoangingToAdd.isPresent()) {
            Stuff.StuffState state = new StuffAsListitem(stuffOfLoangingToAdd.get()).getState();
            if (state == Stuff.StuffState.AVAILABLE) {
                loaning.setStuff(stuffOfLoangingToAdd.get());
            }
            else {
                throw new ConflictException("Because the stuff with id " + loaning.getStuffId() + " is " + state + ", the loaning could not be added.");
            }
        }
        else {
            throw new ConflictException("Because there is no stuff with id " + loaning.getStuffId() + ", the loaning could not be added.");
        }

        if (loaning.getBrought() != null && loaning.getBrought().isBefore(loaning.getTook())) {
            throw new ConflictException("Because brioughtdate is in the past, the loaning could not be added.");
        }
        return repository.save(loaning);
    }

    public Loaning finishLoaning(Long id, Long stuffid) {
        Optional<Loaning> loaningToFinish = findLoaningById(id);
        if (loaningToFinish.isPresent()) {
            if (loaningToFinish.get().getStuffId().equals(stuffid)) {
                if (loaningToFinish.get().getBrought() == null) {
                    loaningToFinish.get().setBrought(LocalDate.now());
                    return repository.save(loaningToFinish.get());
                }
                else {
                    throw new ConflictException("Loaning with id " + id + " is already finished.");
                }
            }
            else {
                throw new ConflictException("The loaning with id " + id + " is not about the stuff with id " + stuffid);
            }
        }
        else {
            throw new ConflictException("No loaning found with id " + id + ".");
        }

    }
}
