package nl.kaiherwijn.pruntilo.controller;

import nl.kaiherwijn.pruntilo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public Optional<Member> findMemberById(Long id) {
        Optional<Member> memberOptional = repository.findById(id);
        return memberOptional;
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }
}
