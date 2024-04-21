package com.artsiushenka.config;

import com.artsiushenka.collection.TableViewCollection;
import com.artsiushenka.collection.TableViewCollectionImpl;
import com.artsiushenka.enums.ColumnName;
import com.artsiushenka.factory.ItemFactory;
import com.artsiushenka.factory.ItemFactoryImpl;
import com.artsiushenka.factory.TableViewFactory;
import com.artsiushenka.factory.TableViewFactoryImpl;
import com.artsiushenka.model.Item;
import com.artsiushenka.provider.GuiProvider;
import com.artsiushenka.provider.JavaFxProviderImpl;
import com.artsiushenka.service.FileService;
import com.artsiushenka.service.FileServiceImpl;
import com.artsiushenka.service.GuiService;
import com.artsiushenka.service.JavaFxServiceImpl;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class SpringConfiguration {
    @Bean
    public ItemFactory itemFactory(){
        return new ItemFactoryImpl();
    }

    @Bean
    public FileService fileService(ItemFactory itemFactory){
        return new FileServiceImpl(itemFactory);
    }

    @Bean
    @Scope("prototype")
    public TableView<Item> tableView(){
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

    @Bean
    public GuiService javaFxService(TableViewCollection tableViewList, TableViewFactory tableViewFactory){
        return new JavaFxServiceImpl(tableViewList, tableViewFactory);
    }

    @Bean
    public TableViewFactory tableViewFactory(ApplicationContext context){
        return new TableViewFactoryImpl(context);
    }

    @Bean
    public GuiProvider guiProvider(TableViewCollection tableViewCollection, FileService fileService, GuiService javaFxService){
        return new JavaFxProviderImpl(tableViewCollection, fileService, javaFxService);
    }

    @Bean
    public TableViewCollection tableViewCollection(List<TableView<Item>> tableViewCollection){
        return new TableViewCollectionImpl(tableViewCollection);
    }
}
