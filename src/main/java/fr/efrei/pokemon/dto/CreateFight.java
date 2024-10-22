package fr.efrei.pokemon.dto;

public class CreateFight {

    private String trainer1Id;
    private String trainer2Id;
    private String location;

    // Getters and Setters
    public String getTrainer1Id() {
        return trainer1Id;
    }

    public void setTrainer1Id(String trainer1Id) {
        this.trainer1Id = trainer1Id;
    }

    public String getTrainer2Id() {
        return trainer2Id;
    }

    public void setTrainer2Id(String trainer2Id) {
        this.trainer2Id = trainer2Id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
