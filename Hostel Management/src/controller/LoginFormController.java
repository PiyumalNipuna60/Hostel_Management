package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public AnchorPane LoginContext;
    public JFXPasswordField txtPassword;
    public CheckBox checkBox;
    public PasswordField pwdPasswordField;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().equalsIgnoreCase("") && txtPassword.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashBoardForm.fxml"));
            Parent parent=loader.load();
            Scene scene=new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1= (Stage)LoginContext.getScene().getWindow();
            stage1.close();
        }else{
            new Alert(Alert.AlertType.ERROR, "Invalid User Name Or Password.Please Try Again" ).show();
        }
    }

    public void checkBoxOnAction(ActionEvent actionEvent) {
        if (checkBox.isSelected()) {
            txtPassword.setText(pwdPasswordField.getText());
            System.out.println("Select");
            pwdPasswordField.setVisible(false);
            txtPassword.setVisible(true);
        } else {
            System.out.println("not");
            pwdPasswordField.setText(txtPassword.getText());
            pwdPasswordField.setVisible(true);
            txtPassword.setVisible(false);
        }
    }
}
