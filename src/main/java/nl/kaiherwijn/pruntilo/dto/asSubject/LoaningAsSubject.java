package nl.kaiherwijn.pruntilo.dto.asSubject;

import nl.kaiherwijn.pruntilo.model.Loaning;

import java.time.LocalDate;

public class LoaningAsSubject {

    private Long id;
    private LocalDate take;
    private LocalDate bring;
    private Long stuffid;
    private String stuffname;
    private Long memberid;
    private String membername;

    public LoaningAsSubject(Loaning loaning) {
        this.id = loaning.getId();
        this.take = loaning.getTake();
        this.bring = loaning.getBring();
        this.stuffid = loaning.getStuff().getId();
        this.stuffname = loaning.getStuff().getName();
        this.memberid = loaning.getMember().getId();
        this.membername = loaning.getMember().getName();
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

    public Long getStuffid() {
        return stuffid;
    }

    public void setStuffid(Long stuffid) {
        this.stuffid = stuffid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }
}
