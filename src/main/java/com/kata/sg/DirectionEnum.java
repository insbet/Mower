package com.kata.sg;

public enum DirectionEnum {
    A('A', "Advance"),
    D('D', "Right"),
    G('G', "Left");

    private char code;
    private String description;

    DirectionEnum(char code, String description) {
        this.code = code;
        this.description = description;
    }

    public char getCode() {
        return code;
    }
}
