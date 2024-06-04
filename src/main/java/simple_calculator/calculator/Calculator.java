package simple_calculator.calculator;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class Calculator {
    // Buttons
    @FXML
    private Button nineButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button zeroButton;

    // LCD
    @FXML
    private TextField outputField;
    
    private ArrayList<Button> buttons;

    // Values to print up
    @FXML
    private Text savedNumField;
    // Values to calculate
    private Long valueA;
    private Long valueB;
    private Long result;
    private String saveOperanding;

    private boolean valueSaveCleared;

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

        this.valueSaveCleared = true;
    }
    
    @FXML
    private void pressedButton(MouseEvent event) {
        Button button = (Button)event.getSource();

        if (!valueSaveCleared) {
            this.outputField.clear();
            valueSaveCleared = true;
        }

        switch(button.getId()) {
            case "nineButton" -> {
                outputField.setText(outputField.getText() + "9");
            }

            case "eightButton" -> {
                outputField.setText(outputField.getText() + "8");
            }

            case "sevenButton" -> {
                outputField.setText(outputField.getText() + "7");
            }

            case "sixButton" -> {
                outputField.setText(outputField.getText() + "6");
            }

            case "fiveButton" -> {
                outputField.setText(outputField.getText() + "5");
            }

            case "fourButton" -> {
                outputField.setText(outputField.getText() + "4");
            }

            case "threeButton" -> {
                outputField.setText(outputField.getText() + "3");
            }

            case "twoButton" -> {
                outputField.setText(outputField.getText() + "2");
            }

            case "oneButton" -> {
                outputField.setText(outputField.getText() + "1");
            }

            case "zeroButton" -> {
                outputField.setText(outputField.getText() + "0");
            }
        }
    }

    @FXML
    private void buttonNumberPressed (MouseEvent event) {
        Button button = (Button)event.getSource();
        button.setStyle("-fx-background-color: #bcabf7");
    }

    @FXML
    private void buttonNumberNotPressed (MouseEvent event) {
        Button button = (Button)event.getSource();
        button.setStyle("-fx-background-color: #cabcff");
    }

    @FXML
    private void calculateAction (MouseEvent event) {
        try {
            Button button = (Button)event.getSource();
            String sValue = String.valueOf(outputField.getText()); // Content from TextField on String
    
            if (valueA == null) {
                this.valueA = Long.valueOf(sValue); // Content from TextField on int
            } else {
                this.valueB = Long.valueOf(sValue);
            }

            this.valueSaveCleared = false;
    
            switch(button.getText()) {
                case "+" -> {
                    if (valueA != null && valueB != null) {
                        this.result = resultWithSaveOperanding(valueA, valueB);
                        this.savedNumField.setText(valueA + " + " + valueB + " =");
                        this.outputField.setText(String.valueOf(result));
                        this.valueA = result;
                        this.valueB = null;
                    } else {
                        this.savedNumField.setText(sValue + " +");
                    }
                    this.saveOperanding = "+";
                }
    
                case "-" -> {
                    if (valueA != null && valueB != null) {
                        this.result = resultWithSaveOperanding(valueA, valueB);
                        this.savedNumField.setText(valueA + " - " + valueB + " =");
                        this.outputField.setText(String.valueOf(result));
                        this.valueA = result;
                        this.valueB = null;
                    } else {
                        this.savedNumField.setText(sValue + " -");
                    }
                    this.saveOperanding = "-";

                }
    
                case "*" -> {
                    if (valueA != null && valueB != null) {
                        this.result = resultWithSaveOperanding(valueA, valueB);
                        this.savedNumField.setText(valueA + " * " + valueB + " =");
                        this.outputField.setText(String.valueOf(result));
                        this.valueA = result;
                        this.valueB = null;
                    } else {
                        this.savedNumField.setText(sValue + " *");
                    }
                    this.saveOperanding = "*";

                }
    
                case "/" -> {
                    if (valueA != null && valueB != null) {
                        this.result = resultWithSaveOperanding(valueA, valueB);
                        this.savedNumField.setText(valueA + " / " + valueB + " =");
                        this.outputField.setText(String.valueOf(result));
                        this.valueA = result;
                        this.valueB = null;
                    } else {
                        this.savedNumField.setText(sValue + " /");
                    }
                    this.saveOperanding = "/";

                }
    
                case "%" -> {
                    if (valueA != null && valueB != null) {
                        this.result = resultWithSaveOperanding(valueA, valueB);
                        this.savedNumField.setText(valueA + " % " + valueB + " =");
                        this.outputField.setText(String.valueOf(result));
                        this.valueA = result;
                        this.valueB = null;
                    } else {
                        this.savedNumField.setText(sValue + " %");
                    }
                    this.saveOperanding = "%";

                }
    
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("El numero proporcionado es demasiado grande");
            alert.show();
        }
    }

    private long resultWithSaveOperanding (Long valueA, Long valueB) {
        switch (saveOperanding) {
            case "+" -> {
                return valueA + valueB;
            }

            case "-" -> {
                return valueA - valueB;
            }

            case "*" -> {
                return valueA * valueB;
            }

            case "/" -> {
                return valueA / valueB;
            }

            case "%" -> {
                return valueA % valueB;
            }
        }

        return Long.MIN_VALUE;
    }

    @FXML
    private void equalsButtonAction () {
        if (valueB == null) {
            this.valueB = Long.valueOf(outputField.getText());
        }

        this.result = resultWithSaveOperanding(valueA, valueB);
        valueA = null;
        valueB = null;
        this.outputField.setText(String.valueOf(result));
    }
    
    private void addButtonsToArrayList () {
        this.buttons = new ArrayList<>();
        buttons.add(nineButton);
        buttons.add(eightButton);
        buttons.add(sevenButton);
        buttons.add(sixButton);
        buttons.add(fiveButton);
        buttons.add(fourButton);
        buttons.add(threeButton);
        buttons.add(twoButton);
        buttons.add(oneButton);
        buttons.add(zeroButton);
    }

    @FXML
    private void initialize() {
        addButtonsToArrayList();
    }
}
