package simple_calculator.calculator;

import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Calculator {
    public Calculator(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/simple_calculator/calculator.fxml"));
        loader.setController(this);

        try {
            Parent parent = loader.load();
            Scene scene = new Scene(parent);

            stage.setTitle("Calculator");
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
