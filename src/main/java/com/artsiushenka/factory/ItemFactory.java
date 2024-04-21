package com.artsiushenka.factory;

import com.artsiushenka.model.Item;

import java.io.IOException;
import java.nio.file.Path;

public interface ItemFactory {
    Item generateItem (Path path) throws IOException;
}
