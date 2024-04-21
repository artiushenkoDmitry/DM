package com.artsiushenka.factory;

import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;

public interface TableViewFactory {
    TableView<Item> getTableView();
}
