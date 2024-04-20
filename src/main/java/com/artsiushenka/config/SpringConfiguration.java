package com.artsiushenka.config;

import com.artsiushenka.enums.ColumnName;
import com.artsiushenka.factory.FileFactory;
import com.artsiushenka.factory.FileFactoryImpl;
import com.artsiushenka.model.Item;
import com.artsiushenka.service.FileService;
import com.artsiushenka.service.FileServiceImpl;
import com.artsiushenka.service.GuiService;
import com.artsiushenka.service.JavaFxImpl;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public FileFactory fileFactory(){
        return new FileFactoryImpl();
    }

    @Bean
    public FileService fileService(FileFactory fileFactory){
        return new FileServiceImpl(fileFactory);
    }

    @Bean
    public TableView<Item> tableView(){
        TableView<Item> table = new TableView<>();
        table.setEditable(true);
        VBox.setVgrow(table, Priority.ALWAYS);
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

    @Bean
    public GuiService javaFxService(FileService fileService, TableView<Item> table){
        return new JavaFxImpl(fileService, table);
    }
}
