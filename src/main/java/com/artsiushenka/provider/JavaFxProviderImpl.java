package com.artsiushenka.provider;

import com.artsiushenka.collection.TableViewCollection;
import com.artsiushenka.model.Item;
import com.artsiushenka.service.FileService;
import com.artsiushenka.service.GuiService;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Paths;

@RequiredArgsConstructor
public class JavaFxProviderImpl implements GuiProvider {
    private final TableViewCollection tableViewCollection;
    private final FileService fileService;
    private final GuiService javaFxService;

    public void startGui(Stage stage) {
        ObservableList<Item> itemList;
        try {
            itemList = fileService.getItemList(Paths.get("."));
            javaFxService.addSingleTable(itemList);
            javaFxService.addSingleTable(itemList);
        } catch (IOException e) {
            //TODO
            handleException(e);
//            throw new RuntimeException(e);
        }


        stage.setTitle("Commander");
        HBox root = new HBox();
        root.getChildren().addAll(tableViewCollection.getTableViewList());
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    @Override
    public void handleException(Exception exception) {

    }

}
