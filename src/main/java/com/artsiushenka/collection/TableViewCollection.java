package com.artsiushenka.collection;

import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;

import java.util.List;

public interface TableViewCollection {
    List<TableView<Item>> getTableViewList();
    void addTableView(TableView<Item> tableView);
}
