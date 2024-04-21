package com.artsiushenka.service;

import com.artsiushenka.factory.TableViewFactory;
import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class JavaFxImpl implements GuiService {
    private final FileService fileService;
    @Getter
    private final List<TableView<Item>> tableViewList;
    private final TableViewFactory tableViewFactory;

    public void drawSingleTable(Path path) throws IOException {
        TableView<Item> tableView = tableViewFactory.getTableView();
        tableView.setItems(fileService.getItemList(path));

        tableViewList.add(tableView);
    }
}
