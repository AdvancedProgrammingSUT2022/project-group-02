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
    requires gson;
    requires java.sql;

    opens controller to javafx.fxml, gson;
    exports controller;
    opens view to javafx.fxml, gson;
    exports view;
    opens view.enums to javafx.fxml, gson;
    exports view.enums;
    opens model to javafx.fxml, gson;
    exports model;

}