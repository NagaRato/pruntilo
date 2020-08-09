package nl.kaiherwijn.pruntilo.dto.asListItem;

import nl.kaiherwijn.pruntilo.model.Loaning;

import java.time.LocalDate;

public class LoaningAsListitem {

    private Long id;
    private LocalDate take;
    private LocalDate bring;
    private String stuffname;
    private String membername;

    public LoaningAsListitem(Loaning loaning) {
        id = loaning.getId();
        take = loaning.getTake();
        bring = loaning.getBring();
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

    public LocalDate getBring() {
        return bring;
    }

    public void setBring(LocalDate bring) {
        this.bring = bring;
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
