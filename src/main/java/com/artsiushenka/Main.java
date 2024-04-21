package com.artsiushenka;

import com.artsiushenka.config.SpringConfiguration;
import com.artsiushenka.provider.GuiProvider;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application{
    ApplicationContext ctx;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        GuiProvider provider = ctx.getBean(GuiProvider.class);
        provider.startGui(stage);
    }
}