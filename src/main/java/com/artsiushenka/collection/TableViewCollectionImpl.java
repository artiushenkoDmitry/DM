package com.artsiushenka.collection;

import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TableViewCollectionImpl implements TableViewCollection{

    private final List<TableView<Item>> tableViewList;

    public List<TableView<Item>> getTableViewList(){
        return tableViewList;
    }
    public void addTableViewList(TableView<Item> tableView){
        tableViewList.add(tableView);
    }
}
