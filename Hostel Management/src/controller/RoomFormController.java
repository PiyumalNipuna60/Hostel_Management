package controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
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

//    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap();
//    Pattern titlePattern = Pattern.compile("^[A-z ]{2,50}$");
//    Pattern namePattern = Pattern.compile("^[A-z ]{3,50}$");
//    Pattern addressPattern = Pattern.compile("^[A-z ]{3,60}$");
//    Pattern cityPattern = Pattern.compile("^[A-z ]{3,60}$");
//    Pattern provincePattern = Pattern.compile("^[A-z ]{3,60}$");
//    Pattern postalCodePattern = Pattern.compile("^[0-9]{4,}$");

//    private void storeValidations() {
//
//        map.put(txtRoomTypeID,);
//        map.put(txtRoomType,);
//        map.put(txtKeyMoney,);
//        map.put(txtQty,);
//    }

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
        public void addStudentRoomOnAction (ActionEvent actionEvent){
        }

        public void clearFOrmOnAction (ActionEvent actionEvent){
        }

        public void SearchMatchingResults (KeyEvent keyEvent){
        }

        public void CloseOnAction (MouseEvent mouseEvent){
        }

    public void ValidateFields(KeyEvent keyEvent) {
    }
}



