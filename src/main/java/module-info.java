module fxmedia {
    requires javafx.media;
    requires javafx.fxml;
    requires javafx.controls;

    exports pl.javastart.fxmedia to javafx.graphics;
    opens pl.javastart.fxmedia to javafx.fxml;
}