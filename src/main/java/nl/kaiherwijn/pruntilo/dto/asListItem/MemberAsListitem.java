package nl.kaiherwijn.pruntilo.dto.asListItem;

import nl.kaiherwijn.pruntilo.model.Member;

public class MemberAsListitem {

    private Long id;
    private String name;
    private long countLoanings;
    private long countCurrentLoanings;

    public MemberAsListitem(Member member) {
        id = member.getId();
        name = member.getName();
        countLoanings = member.getLoanings().size();
        countCurrentLoanings = member.getLoanings().stream().filter(l-> l.getBrought() == null).count();
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

    public long getCountLoanings() {
        return countLoanings;
    }

    public long getCountCurrentLoanings() {
        return countCurrentLoanings;
    }
}
