package nl.kaiherwijn.pruntilo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Stuff {
    public enum StuffState {AVAILABLE, LENT}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;

    @OneToMany
    @JoinColumn(name = "stuff_id")
    private List<Loaning> loanings = new ArrayList<>();

    public Stuff() {
    }

    public Stuff(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Loaning> getLoanings() {
        return loanings;
    }
}
