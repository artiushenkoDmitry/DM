package com.artsiushenka.service;

import com.artsiushenka.collection.TableViewCollection;
import com.artsiushenka.factory.TableViewFactory;
import com.artsiushenka.model.Item;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JavaFxServiceImpl implements GuiService {
    private final TableViewCollection tableViewList;
    private final TableViewFactory tableViewFactory;

    public void addSingleTable(ObservableList<Item> items) {
        TableView<Item> tableView = tableViewFactory.getTableView();
        tableView.setItems(items);

        tableViewList.addTableViewList(tableView);
    }
}
