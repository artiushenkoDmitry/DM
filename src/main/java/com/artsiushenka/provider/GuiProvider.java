package com.artsiushenka.provider;

import javafx.stage.Stage;

public interface GuiProvider {
    void startGui(Stage stage);

    void handleException(Exception exception, Stage stage);
}
