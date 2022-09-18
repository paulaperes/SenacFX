package senac.senacfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import senac.senacfx.gui.util.Alerts;
import senac.senacfx.gui.util.Constraints;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;

    @FXML
    private Label labelResult;

    @FXML
    private Button btSum;
    @FXML
    public void onBtSumAction(){
        try{
            Locale.setDefault(Locale.US);
            double n1 = Double.parseDouble(txt1.getText());
            double n2 = Double.parseDouble(txt2.getText());
            double sum = n1 + n2;
            labelResult.setText(String.format("%.2f", sum));
        } catch (NumberFormatException e){
            Alerts.showAlert("Error", "Parse error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private Button bTest;
    @FXML
    public void onBtTestAction(){
        Alerts.showAlert("ERRO", "DEU RUIM", "VAI EXPLODIR", Alert.AlertType.ERROR);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(txt1);
        Constraints.setTextFieldDouble(txt2);
        Constraints.setTextFieldMaxLength(txt1, 5);
        Constraints.setTextFieldMaxLength(txt2, 5);
        Constraints.setTextFieldInteger(txt1);
        Constraints.setTextFieldInteger(txt2);
    }
}