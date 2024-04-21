package com.artsiushenka.provider;

import com.artsiushenka.model.Item;
import com.artsiushenka.service.GuiService;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
public class JavaFxProviderImpl implements GuiProvider {
    private final List<TableView<Item>> tableViewList;
    private final GuiService javaFxService;

    public void startGui(Stage stage) {
        try {
            javaFxService.drawSingleTable(Paths.get("."));
            javaFxService.drawSingleTable(Paths.get("."));
        } catch (IOException e) {
            //TODO
            handleException(e);
//            throw new RuntimeException(e);
        }

        stage.setTitle("Commander");
        HBox root = new HBox();
        root.getChildren().addAll(javaFxService.getTableViewList());
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    @Override
    public void handleException(Exception exception) {

    }

}
