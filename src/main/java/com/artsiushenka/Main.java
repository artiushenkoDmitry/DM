package com.artsiushenka;

import com.artsiushenka.config.SpringConfiguration;
import com.artsiushenka.service.GuiService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Paths;

public class Main extends Application{
    ApplicationContext ctx;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        GuiService javaFxService = ctx.getBean(GuiService.class);

        javaFxService.drawSingleTable(Paths.get("."));
        javaFxService.drawSingleTable(Paths.get("."));

        stage.setTitle("Commander");
        HBox root = new HBox();
        root.getChildren().addAll(javaFxService.getTableViewList());
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}