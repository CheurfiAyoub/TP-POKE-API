package fr.efrei.pokemon.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "trainer1_id")
    private Trainer trainer1;

    @ManyToOne
    @JoinColumn(name = "trainer2_id")
    private Trainer trainer2;

    @OneToMany
    private List<Pokemon> teamTrainer1;

    @OneToMany
    private List<Pokemon> teamTrainer2;

    private String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public List<Pokemon> getTeamTrainer1() {
        return teamTrainer1;
    }

    public void setTeamTrainer1(List<Pokemon> teamTrainer1) {
        this.teamTrainer1 = teamTrainer1;
    }

    public List<Pokemon> getTeamTrainer2() {
        return teamTrainer2;
    }

    public void setTeamTrainer2(List<Pokemon> teamTrainer2) {
        this.teamTrainer2 = teamTrainer2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
