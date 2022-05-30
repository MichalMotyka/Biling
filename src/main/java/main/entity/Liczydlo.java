package main.entity;

import lombok.Data;

@Data
public class Liczydlo {
    private Integer id;
    private final String name;
    private final String type;

    public Liczydlo(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
