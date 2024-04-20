package com.artsiushenka.service;

import com.artsiushenka.factory.FileFactory;
import com.artsiushenka.model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    private final FileFactory fileFactory;

    public ObservableList<Item> getItemList(Path path) throws IOException {
        List<Item> itemList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path entry : stream) {
                itemList.add(fileFactory.generateItem(entry));
            }
        }

        return FXCollections.observableArrayList(itemList);
    }

}
