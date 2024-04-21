package com.artsiushenka.service;

import com.artsiushenka.factory.ItemFactory;
import com.artsiushenka.model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    private final ItemFactory itemFactory;

    public ObservableList<Item> getItemList(Path path) throws IOException {
        List<Item> itemList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path entry : stream) {
                itemList.add(itemFactory.generateItem(entry));
            }
        }

        return FXCollections.observableArrayList(itemList);
    }

}
