package com.artsiushenka.factory;

import com.artsiushenka.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import javafx.scene.control.TableView;

@RequiredArgsConstructor
public class TableViewFactoryImpl implements TableViewFactory{
    private final ApplicationContext applicationContext;
    public TableView<Item> getTableView(){
        return applicationContext.getBean(TableView.class);
    }
}
