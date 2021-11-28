package com.kata.sg;

import java.util.List;

public class MowerInstructionsDto {

    private Mower mower;
    private List<DirectionEnum> directions;

    public MowerInstructionsDto(Mower mower, List<DirectionEnum> directions) {
        this.mower = mower;
        this.directions = directions;
    }

    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;
    }

    public List<DirectionEnum> getDirections() {
        return directions;
    }

    public void setDirections(List<DirectionEnum> directions) {
        this.directions = directions;
    }
}
