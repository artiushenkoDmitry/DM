package com.artsiushenka.factory;

import com.artsiushenka.enums.ItemType;
import com.artsiushenka.model.Item;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileFactoryImpl implements FileFactory{

    public Item generateItem (Path path) throws IOException {
        return new Item(new SimpleStringProperty(getTypeColumnValue(path)),
                new SimpleStringProperty(path.getFileName().toString()),
                new SimpleStringProperty(getModifiedDateTimeValue(path)),
                new SimpleStringProperty(getSizeValue(path)));
    }

    private String getSizeValue(Path path) throws IOException {
        if (Files.isSymbolicLink(path)) {
            return "[LINK]";
        }
        if (Files.isDirectory(path)) {
            return "[DIR]";
        }
        return String.format("%,d", Files.size(path));
    }

    private String getModifiedDateTimeValue(Path path) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(Files.getLastModifiedTime(path).toMillis()), ZoneId.systemDefault()).format(formatter);
    }

    private String getTypeColumnValue(Path path) {
        if (Files.isSymbolicLink(path)) {
            return ItemType.LINK.getType();
        }
        if (Files.isDirectory(path)) {
            return ItemType.DIRECTORY.getType();
        }
        return ItemType.FILE.getType();
    }
}
