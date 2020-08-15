package nl.kaiherwijn.pruntilo.dto.asListItem;

import nl.kaiherwijn.pruntilo.model.Stuff;


public class StuffAsListitem {

    private long countCurrentLoanings;
    private long countLoanings;
    private Long id;
    private String name;
    private Stuff.StuffState state;

    public StuffAsListitem(Stuff stuff) {
        id = stuff.getId();
        name = stuff.getName();
        countLoanings = stuff.getLoanings().size();
        if (stuff.getLoanings().stream().anyMatch(m -> m.getBrought() == null)) {
            state = Stuff.StuffState.LENT;
        }
        else {
            state = Stuff.StuffState.AVAILABLE;
        }
        countCurrentLoanings = stuff.getLoanings().stream().filter(l-> l.getBrought() == null).count();
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

    public Stuff.StuffState getState() {
        return state;
    }

    public long getCountCurrentLoanings() {
        return countCurrentLoanings;
    }
}
