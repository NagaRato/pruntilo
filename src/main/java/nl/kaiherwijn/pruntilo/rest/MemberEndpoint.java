package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.MemberService;
import nl.kaiherwijn.pruntilo.dto.asSubject.MemberAsSubject;
import nl.kaiherwijn.pruntilo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MemberEndpoint {

    @Autowired
    MemberService service;

    @GetMapping("member/{id}")
    public @ResponseBody
    ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Optional<Member> member = service.findMemberById(id);

        if (member.isPresent()) {
            return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("member")
    public @ResponseBody
    ResponseEntity<List<MemberAsSubject>> getAllMembers() {
        List<MemberAsSubject> memberSimpleList = service.findAllMembers().stream().map(m -> new MemberAsSubject(m)).collect(Collectors.toList());
        return new ResponseEntity<List<MemberAsSubject>>(memberSimpleList, HttpStatus.OK);
    }
}
