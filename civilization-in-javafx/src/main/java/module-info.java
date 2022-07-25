module com.example.civilizationinjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires javafx.media;
    requires java.base;
    requires gson;
    requires gson.extras;

    opens controller to javafx.fxml, gson, gson.extras;
    exports controller;
    opens view to javafx.fxml, gson, gson.extras;
    exports view;
    opens view.enums to javafx.fxml, gson, gson.extras;
    exports view.enums;
    opens model to javafx.fxml, gson, gson.extras;
    exports model;
}