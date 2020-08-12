package nl.kaiherwijn.pruntilo.dto.asListItem;

import nl.kaiherwijn.pruntilo.model.Loaning;

import java.time.LocalDate;

public class LoaningAsListitem {

    private Long id;
    private LocalDate take;
    private LocalDate brought;
    private String stuffname;
    private String membername;

    public LoaningAsListitem(Loaning loaning) {
        id = loaning.getId();
        take = loaning.getTook();
        brought = loaning.getBrought();
        stuffname = loaning.getStuff().getName();
        membername = loaning.getMember().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTake() {
        return take;
    }

    public void setTake(LocalDate take) {
        this.take = take;
    }

    public LocalDate getBrought() {
        return brought;
    }

    public void setBrought(LocalDate brought) {
        this.brought = brought;
    }

    public String getStuffname() {
        return stuffname;
    }

    public void setStuffname(String stuffname) {
        this.stuffname = stuffname;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }
}
