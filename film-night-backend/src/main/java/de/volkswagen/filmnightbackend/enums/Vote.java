package de.volkswagen.filmnightbackend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Vote {

    NOT_VOTED("Not voted"),
    YES("Yes"),
    NO("No");

    private String vote;

    Vote(String vote) {
        this.vote = vote;
    }


    @JsonCreator
    public Vote encode(String name) {
        return Stream.of(Vote.values()).filter(e -> e.vote.equals(name)).findAny().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return this.vote;
    }

}

