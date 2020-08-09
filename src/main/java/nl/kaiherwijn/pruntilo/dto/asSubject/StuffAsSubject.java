package nl.kaiherwijn.pruntilo.dto.asSubject;

import nl.kaiherwijn.pruntilo.dto.asListItem.LoaningAsListitem;
import nl.kaiherwijn.pruntilo.model.Stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StuffAsSubject {

    private Long id;
    private String name;
    private List<LoaningAsListitem> loanings = new ArrayList<>();

    public StuffAsSubject(Stuff stuff) {
        id = stuff.getId();
        name = stuff.getName();
        loanings = stuff.getLoanings().stream().map(s -> new LoaningAsListitem(s)).collect(Collectors.toList());
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

    public List<LoaningAsListitem> getLoanings() {
        return loanings;
    }
}
