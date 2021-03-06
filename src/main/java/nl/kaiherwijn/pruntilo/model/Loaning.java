package nl.kaiherwijn.pruntilo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Loaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate took;
    private LocalDate brought;

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

    public void setId(@NotNull(message = "the id of a loaning cannot be null") Long id) {
        this.id = id;
    }

    public LocalDate getTook() {
        return took;
    }

    public void setTook(@NotNull(message = "took of a loaning cannot be null") LocalDate took) {
        this.took = took;
    }

    public LocalDate getBrought() {
        return brought;
    }

    public void setBrought(LocalDate brought) {
        this.brought = brought;
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

    public void setStuffId(@NotNull Long stuffId) {
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

    public void setMemberId(@NotNull Long memberId) {
        this.memberId = memberId;
    }
}
