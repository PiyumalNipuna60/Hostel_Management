package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.postalCode;

public class StudentFormController {
    public JFXTextField txtStudentID;
    public JFXTextField txtAddress;
    public JFXTextField txtStudentName;
    public TableView tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colMobile;
    public TableColumn colDOB;
    public TableColumn colGender;
    public TableColumn colOption;
    public JFXTextField txtContactNo;
    public JFXDatePicker dockerDOB;
    public JFXComboBox cmbGender;
    public JFXButton btnAddStudent;
    public JFXButton btnCancel;
    public JFXTextField txtSearch;

    public void validateFieldsOnKeyRelease(KeyEvent keyEvent) {
    }

    public void clearFormOnAction(ActionEvent actionEvent) {
    }

    public void addStudentOnAction(ActionEvent actionEvent) {
    }

    public void SearchMatching(KeyEvent keyEvent) {
    }
}
