package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

public class UserManagementFormController {
    public JFXTextField txtNic;
    public JFXTextField txtUserName;
    public JFXTextField txtName;
    public TableView tblUser;
    public TableColumn colNIC;
    public TableColumn colName;
    public TableColumn colUsername;
    public TableColumn userPassword;
    public TableColumn colOption;
    public JFXTextField txtPassword;
    public JFXButton btnAddUser;
    public JFXButton btnCancel;
    public JFXTextField txtSearch;
    public JFXTextField txtConfirmPassword;

    public void validateFieldsOnKeyReleased(KeyEvent keyEvent) {
    }

    public void addUserOnAction(ActionEvent actionEvent) {
    }

    public void clearFormOnAction(ActionEvent actionEvent) {
    }

    public void searchUserOnKeyReleased(KeyEvent keyEvent) {
    }
}
