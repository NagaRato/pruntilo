package nl.kaiherwijn.pruntilo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Loaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate take;
    private LocalDate bring;

    @ManyToOne
    @JsonIgnore
    private Stuff stuff;
    @Transient // niet in database opslaan, wel in JSON
    @JsonProperty("stuff") // naam van het originele veld => naam in JSON
    private Long stuffId;
    @ManyToOne
    @JsonIgnore
    private Member member;
    @Transient
    @JsonProperty("member")
    private Long memberId;

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

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Long getStuffId() {
        return stuffId;
    }

    public void setStuffId(Long stuffId) {
        this.stuffId = stuffId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
