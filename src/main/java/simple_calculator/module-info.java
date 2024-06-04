module calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens simple_calculator to javafx.fxml;
    opens simple_calculator.calculator to javafx.fxml;
    
    exports simple_calculator;
    exports simple_calculator.calculator;
}