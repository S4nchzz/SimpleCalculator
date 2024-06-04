package simple_calculator;

import javafx.application.Application;
import javafx.stage.Stage;
import simple_calculator.calculator.Calculator;

import java.io.IOException;
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new Calculator(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}