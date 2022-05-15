module com.example.mp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.media;
    requires java.desktop;

    opens mediaplayer to javafx.fxml;
    exports mediaplayer;
    exports mediaplayer.decorator;
    opens mediaplayer.decorator to javafx.fxml;
    exports mediaplayer.builder;
    opens mediaplayer.builder to javafx.fxml;
}