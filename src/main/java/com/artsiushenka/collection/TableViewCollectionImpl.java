package com.artsiushenka.collection;

import com.artsiushenka.model.Item;
import javafx.scene.control.TableView;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TableViewCollectionImpl implements TableViewCollection{

    private final List<TableView<Item>> tableViewList;

    //TODO
    public List<TableView<Item>> getTableViewList(){
        return tableViewList.stream()
                .filter(e -> !e.getItems().isEmpty())
                .toList();
    }
    public void addTableViewList(TableView<Item> tableView){
        tableViewList.add(tableView);
    }
}
