package nl.kaiherwijn.pruntilo.dto.asListItem;

import nl.kaiherwijn.pruntilo.model.Stuff;


public class StuffAsListitem {

    private int countLoanings;
    private Long id;
    private String name;
    private final Stuff.StuffState state;

    public StuffAsListitem(Stuff stuff) {
        id = stuff.getId();
        name = stuff.getName();
        countLoanings = stuff.getLoanings().size();
        if (stuff.getLoanings().stream().filter(m-> m.getBrought() == null).count() > 0) {
            state = Stuff.StuffState.LENT;
        }
        else {
            state = Stuff.StuffState.AVAILABLE;
        }
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

    public Stuff.StuffState getState() {
        return state;
    }
}
