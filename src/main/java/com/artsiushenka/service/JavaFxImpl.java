package com.artsiushenka.service;

import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Path;

@RequiredArgsConstructor
public class JavaFxImpl implements GuiService {
    private final FileService fileService;
    private final TableView<Item> table;

    public TableView<Item> drawSingleTable(Path path) throws IOException {
        table.setItems(fileService.getItemList(path));

        return table;
    }
}
