package nl.kaiherwijn.pruntilo.dto.asListItem;

import nl.kaiherwijn.pruntilo.model.Member;

public class MemberAsListitem {

    private Long id;
    private String name;

    public MemberAsListitem(Member member) {
        this.id = member.getId();
        this.name = member.getName();
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
}
