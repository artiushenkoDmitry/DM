package com.artsiushenka.provider;

import com.artsiushenka.collection.TableViewCollection;
import com.artsiushenka.model.Item;
import com.artsiushenka.service.FileService;
import com.artsiushenka.service.GuiService;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
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
            throw new IOException("Just another exception");
        } catch (IOException e) {
            handleException(e, stage);
        }


        stage.setTitle("Commander");
        HBox root = new HBox();
        root.getChildren().addAll(tableViewCollection.getTableViewList());
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    @Override
    public void handleException(Exception exception, Stage stage) {
        //TODO
        Label label = new Label(exception.getMessage());
        label.setMinWidth(80);
        label.setMinHeight(50);

        Popup popup = new Popup();
        popup.setX(300);
        popup.setY(200);
        popup.getContent().add(label);
        popup.show(stage);
    }

}
