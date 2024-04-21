package com.artsiushenka.service;

import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface GuiService {
    void drawSingleTable(Path path) throws IOException;
    List<TableView<Item>> getTableViewList();
}
