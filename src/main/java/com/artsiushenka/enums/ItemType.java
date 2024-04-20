package com.artsiushenka.enums;

public enum ItemType {
    FILE("F"), DIRECTORY("D"), LINK("L");
    private String type;

    ItemType(String name) {
        this.type = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
