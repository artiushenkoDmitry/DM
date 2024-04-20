package com.artsiushenka;

import com.artsiushenka.config.SpringConfiguration;
import com.artsiushenka.service.JavaFxImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
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
        JavaFxImpl javaFxService = ctx.getBean(JavaFxImpl.class);
        TableView tableView = javaFxService.drawSingleTable(Paths.get("."));

        stage.setTitle("Commander");
        VBox root = new VBox();
        root.getChildren().add(tableView);
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}