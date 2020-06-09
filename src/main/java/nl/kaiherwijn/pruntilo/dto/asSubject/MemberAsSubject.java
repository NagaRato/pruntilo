package nl.kaiherwijn.pruntilo.dto.asSubject;

import nl.kaiherwijn.pruntilo.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberAsSubject {

    private Long id;
    private String name;
    private List<Long> loaningIds = new ArrayList<>();

    public MemberAsSubject(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.loaningIds = member.getLoanings().stream().map(m -> m.getId()).collect(Collectors.toList());
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

    public List<Long> getLoaningIds() {
        return loaningIds;
    }

    public void setLoaningIds(List<Long> loaningIds) {
        this.loaningIds = loaningIds;
    }
}
