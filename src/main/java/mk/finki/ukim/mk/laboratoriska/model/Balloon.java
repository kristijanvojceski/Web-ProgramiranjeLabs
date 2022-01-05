package mk.finki.ukim.mk.laboratoriska.model;

import lombok.Data;

@Data
public class Balloon {

    private String name;
    private String description;

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
