package com.artsiushenka.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.nio.file.Path;

//@Getter
//@Setter
//@RequiredArgsConstructor
public class Item {
    public final SimpleStringProperty type;
    public final SimpleStringProperty itemName;
    public final SimpleStringProperty modifiedDateTime;
    public final SimpleStringProperty size;

    public Item(SimpleStringProperty type, SimpleStringProperty itemName, SimpleStringProperty modifiedDateTime, SimpleStringProperty size) {
        this.type = type;
        this.itemName = itemName;
        this.modifiedDateTime = modifiedDateTime;
        this.size = size;
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public String getModifiedDateTime() {
        return modifiedDateTime.get();
    }

    public void setModifiedDateTime(String modifiedDateTime) {
        this.modifiedDateTime.set(modifiedDateTime);
    }

    public SimpleStringProperty modifiedDateTimeProperty() {
        return modifiedDateTime;
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

}

