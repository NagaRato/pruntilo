package nl.kaiherwijn.pruntilo.dto.asSubject;

import nl.kaiherwijn.pruntilo.dto.asListItem.LoaningAsListitem;
import nl.kaiherwijn.pruntilo.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class MemberAsSubject {

    private Long id;
    private String name;
    private List<LoaningAsListitem> loanings;

    private List<LoaningAsListitem> currentLoanings;

    public MemberAsSubject(Member member) {
        id = member.getId();
        name = member.getName();
        loanings = member.getLoanings().stream().map(LoaningAsListitem::new).collect(Collectors.toList());
        currentLoanings = member.getLoanings().stream().filter(m-> m.getBrought() == null).map(LoaningAsListitem::new).collect(Collectors.toList());
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

    public List<LoaningAsListitem> getCurrentLoanings() {
        return loanings.stream().filter(l-> l.getBrought() == null).collect(Collectors.toList());
    }

    public List<LoaningAsListitem> getLoanings() {
        return loanings;
    }

    public Map<Integer, Long> getCountLoaningsPerYear() {
        return loanings.stream().collect(Collectors.groupingBy(l -> l.getTook().getYear(), Collectors.counting()));
    }
}
