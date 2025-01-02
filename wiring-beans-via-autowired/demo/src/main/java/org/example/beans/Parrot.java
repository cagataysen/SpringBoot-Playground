package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

    private String name = "Cagatay";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }

}
