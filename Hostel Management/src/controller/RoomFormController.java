package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class RoomFormController {
    public JFXTextField txtRoomTypeID;
    public JFXTextField txtQty;
    public JFXTextField txtRoomType;
    public TableView tblRooms;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public TableColumn colOption;
    public JFXTextField txtKeyMoney;
    public JFXButton btnAddRoom;
    public JFXButton btnCancel;
    public JFXTextField txtSearch;


    public void ValidateFields(KeyEvent keyEvent) {
    }

    public void addStudentRoomOnAction(ActionEvent actionEvent) {
    }

    public void clearFOrmOnAction(ActionEvent actionEvent) {
    }

    public void SearchMatchingResults(KeyEvent keyEvent) {
    }

    public void CloseOnAction(MouseEvent mouseEvent) {
    }
}
