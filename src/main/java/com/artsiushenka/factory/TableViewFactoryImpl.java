package com.artsiushenka.factory;

import com.artsiushenka.enums.ColumnName;
import com.artsiushenka.model.Item;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import javafx.scene.control.TableView;

@RequiredArgsConstructor
public class TableViewFactoryImpl implements TableViewFactory{
    public TableView<Item> getTableView(){
        TableView<Item> table = new TableView<>();
        table.setEditable(true);
        VBox.setVgrow(table, Priority.ALWAYS);
        HBox.setHgrow(table, Priority.ALWAYS);
        TableColumn<Item, String> typeCol = new TableColumn(ColumnName.TYPE.getValue());
        typeCol.setCellValueFactory(new PropertyValueFactory("type"));
        typeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));

        TableColumn<Item, String> itemNameCol = new TableColumn(ColumnName.ITEM_NAME.getValue());
        itemNameCol.setCellValueFactory(new PropertyValueFactory("itemName"));
        itemNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.4));

        TableColumn<Item, String> lmCol = new TableColumn(ColumnName.LAST_MODIFIED.getValue());
        lmCol.setCellValueFactory(new PropertyValueFactory("modifiedDateTime"));
        lmCol.prefWidthProperty().bind(table.widthProperty().multiply(0.4));

        TableColumn<Item, String> sizeCol = new TableColumn(ColumnName.SIZE.getValue());
        sizeCol.setCellValueFactory(new PropertyValueFactory("size"));
        sizeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));

        table.getColumns().addAll(typeCol, itemNameCol, lmCol, sizeCol);

        return table;
    }
}
