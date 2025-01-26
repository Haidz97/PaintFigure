module org.example.paintfigure {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.paintfigure to javafx.fxml;
    exports org.example.paintfigure;
}