module calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens simple_calculator to javafx.fxml;
    exports simple_calculator;
}