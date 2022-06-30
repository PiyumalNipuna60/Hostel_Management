package controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


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

    //
//    public void initialize() {
//        btnAddRoom.setDisable(true);
//        colId.setCellValueFactory(new PropertyValueFactory<>("room_Type_id"));
//        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
//        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
//        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
//        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
//
//    }
    public void addStudentRoomOnAction(ActionEvent actionEvent) {
        String room_type_id = txtRoomTypeID.getText();
        String type = txtRoomType.getText();
        String key_money = txtKeyMoney.getText();
        Integer qty = Integer.valueOf(txtQty.getText());


        if (!room_type_id.matches("[A-Za-z0-9 ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid description").show();
            txtRoomTypeID.requestFocus();
            return;
        } else if (!type.matches("^$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid unit price").show();
            txtRoomType.requestFocus();
            return;
        } else if (!key_money.matches("^$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid qty on hand").show();
            txtKeyMoney.requestFocus();
            return;
//            } else if (!qty.matches("^$")) {
//                new Alert(Alert.AlertType.ERROR, "Invalid qty on hand").show();
//                txtQty.requestFocus();
//                return;
        }
    }

    public void clearFOrmOnAction(ActionEvent actionEvent) {
    }

    public void SearchMatchingResults(KeyEvent keyEvent) {
    }

    public void CloseOnAction(MouseEvent mouseEvent) {
    }

    public void ValidateFields(KeyEvent keyEvent) {
    }

//    boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//
//    }
}



