module org.example.radiuscalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.radiuscalculator to javafx.fxml;
    exports org.example.radiuscalculator;
}