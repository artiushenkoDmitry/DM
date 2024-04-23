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
import java.util.stream.Collectors;

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
    public GuiService javaFxService(TableViewCollection tableViewList, TableViewFactory tableViewFactory){
        return new JavaFxServiceImpl(tableViewList, tableViewFactory);
    }

    @Bean
    public TableViewFactory tableViewFactory(){
        return new TableViewFactoryImpl();
    }

    @Bean
    public GuiProvider guiProvider(TableViewCollection tableViewCollection, FileService fileService, GuiService javaFxService){
        return new JavaFxProviderImpl(tableViewCollection, fileService, javaFxService);
    }

    @Bean
    public TableViewCollection tableViewCollection(List<TableView<Item>> tableViewCollection){
        List<TableView<Item>> result = tableViewCollection.stream()
                .filter(e -> !e.getItems().isEmpty())
                .collect(Collectors.toList());

        return new TableViewCollectionImpl(result);
    }
}
