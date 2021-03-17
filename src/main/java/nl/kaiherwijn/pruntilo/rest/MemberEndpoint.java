package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.MemberService;
import nl.kaiherwijn.pruntilo.dto.asListItem.MemberAsListitem;
import nl.kaiherwijn.pruntilo.dto.asSubject.MemberAsSubject;
import nl.kaiherwijn.pruntilo.model.Member;
import nl.kaiherwijn.pruntilo.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MemberEndpoint {

    @Autowired
    MemberService service;

    @GetMapping("member/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity<MemberAsSubject> getMemberById(@PathVariable Long id) {
        return service.findMemberById(id).map(value -> new ResponseEntity<>(new MemberAsSubject(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("member")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity<List<MemberAsListitem>> getAllMembers() {
        List<MemberAsListitem> memberSimpleList = service.findAllMembers().stream().map(MemberAsListitem::new).collect(Collectors.toList());
        return new ResponseEntity<>(memberSimpleList, HttpStatus.OK);
    }

    @PostMapping("member")
    @ResponseStatus(HttpStatus.CREATED)
    public Member addMember(@RequestBody @Valid Member member) {
        return service.addMember(member);
    }

    @GetMapping("countactiveMember/{year}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int countactiveMember(@PathVariable int year) {
        return service.findAllMembers().stream().filter(
                member -> member.getLoanings().stream().filter(loaning -> loaning.getTook().getYear() == year).count() > 0
        ).collect(Collectors.toList()).size();
    }
}
