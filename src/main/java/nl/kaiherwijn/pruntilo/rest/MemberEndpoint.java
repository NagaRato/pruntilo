package nl.kaiherwijn.pruntilo.rest;

import nl.kaiherwijn.pruntilo.controller.MemberService;
import nl.kaiherwijn.pruntilo.dto.asListItem.MemberAsListitem;
import nl.kaiherwijn.pruntilo.dto.asSubject.MemberAsSubject;
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
public class MemberEndpoint {

    @Autowired
    MemberService service;

    @GetMapping("member/{id}")
    public @ResponseBody
    ResponseEntity<MemberAsSubject> getMemberById(@PathVariable Long id) {
        return service.findMemberById(id).map(value -> new ResponseEntity<>(new MemberAsSubject(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("member")
    public @ResponseBody
    ResponseEntity<List<MemberAsListitem>> getAllMembers() {
        List<MemberAsListitem> memberSimpleList = service.findAllMembers().stream().map(MemberAsListitem::new).collect(Collectors.toList());
        return new ResponseEntity<>(memberSimpleList, HttpStatus.OK);
    }
}
