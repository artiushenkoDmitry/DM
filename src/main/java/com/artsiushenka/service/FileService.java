package com.artsiushenka.service;

import com.artsiushenka.model.Item;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileService {
    ObservableList<Item> getItemList(Path path) throws IOException;
}
