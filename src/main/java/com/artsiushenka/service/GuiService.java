package com.artsiushenka.service;

import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.nio.file.Path;

public interface GuiService {
    TableView<Item> drawSingleTable(Path path) throws IOException;
}
