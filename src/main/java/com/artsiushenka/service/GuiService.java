package com.artsiushenka.service;

import javafx.scene.control.TableView;

import java.io.IOException;
import java.nio.file.Path;

public interface GuiService {
    TableView drawSingleTable(Path path) throws IOException;
}
