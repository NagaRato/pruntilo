package nl.kaiherwijn.pruntilo.dto.asSubject;

import nl.kaiherwijn.pruntilo.dto.asListItem.LoaningAsListitem;
import nl.kaiherwijn.pruntilo.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberAsSubject {

    private Long id;
    private String name;
    private List<LoaningAsSubject> loanings = new ArrayList<>();

    public MemberAsSubject(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.loanings = member.getLoanings().stream().map(m -> new LoaningAsSubject(m)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LoaningAsSubject> getLoanings() {
        return loanings;
    }
}
