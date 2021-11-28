package com.kata.sg;

public enum OrientationEnum {

    N("N", "North"),
    E("E", "East"),
    W("W", "West"),
    S("S", "South");

    private String code;
    private String description;

    OrientationEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }
}
