package com.artsiushenka.enums;

public enum ColumnName {
    TYPE("type"),
    ITEM_NAME("item name"),
    LAST_MODIFIED("last modified"),
    SIZE("size");

    private String value;

    ColumnName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
