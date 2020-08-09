package nl.kaiherwijn.pruntilo.dto.asListItem;

import nl.kaiherwijn.pruntilo.model.Stuff;


public class StuffAsListitem {

    private int countLoanings;
    private Long id;
    private String name;

    public StuffAsListitem(Stuff stuff) {
        this.id = stuff.getId();
        this.name = stuff.getName();
        countLoanings = stuff.getLoanings().size();
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

    public int getCountLoanings() {
        return countLoanings;
    }
}
