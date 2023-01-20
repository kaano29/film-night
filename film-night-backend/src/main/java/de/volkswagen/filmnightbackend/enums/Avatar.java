package de.volkswagen.filmnightbackend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Avatar {

    CAR("Car"),
    ANIMAL("Animal"),
    BALL("Ball"),
    DEFAULT("Default");

    private String avatar;

    Avatar(String avatar) {
        this.avatar = avatar;
    }

    @JsonCreator
    public Avatar encode(String name) {
        return Stream.of(Avatar.values()).filter(e -> e.avatar.equals(name)).findAny().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return this.avatar;
    }

}

