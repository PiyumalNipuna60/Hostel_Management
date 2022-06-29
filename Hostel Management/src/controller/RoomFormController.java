package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
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
    private final RoomBO rBO = (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);
    private final LinkedHashMap<JFXTextField, Pattern> regexMap = new LinkedHashMap<>();
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

    public void initialize() {
        btnAddRoom.setDisable(true);
        colId.setCellValueFactory(new PropertyValueFactory<>("room_Type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        try {
            loadAllRooms(rBO.getAllRooms());
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }

        regexMap.put(txtRoomTypeID,Pattern.compile("^(RM-)[0-9]{4}$"));
        regexMap.put(txtRoomType,Pattern.compile("^[A-z ,-/0-9]+$"));
        regexMap.put(txtQty,Pattern.compile("^[0-9]+$"));
        regexMap.put(txtKeyMoney,Pattern.compile("^[0-9]+([.]{1}[0-9]{1,2})?+$"));



        tblRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setUpdateFields(newValue);
            }
        });
    }

    private void setUpdateFields(Object tm) {
        btnAddRoom.setText("Update Room");
        btnAddRoom.setDisable(false);
        txtTypeID.setText(tm.getRoom_Type_id());
        txtRoomType.setText(tm.getType());
        txtQty.setText(tm.getQty() + "");
        txtKeyMoney.setText(tm.getKey_money());
    }

    private void loadAllRooms(ArrayList<RoomDTO> rooms) {
        tblRooms.setItems(FXCollections.observableArrayList(rooms.stream().map(dto -> {
            return new RoomTM(dto.getRoom_Type_id(), dto.getType(), dto.getKey_money(), dto.getQty(), getButton(dto.getRoom_Type_id()));
        }).collect(Collectors.toList())));
    }

    public void ValidateFields(KeyEvent keyEvent) {
    }

    public void CloseOnAction(MouseEvent mouseEvent) throws IOException {
//        URL resource = getClass().getResource("../view/ManageItemForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        .getChildren().clear();
//        AdminLoadContext.getChildren().add(load);
    }

    public void SearchMatchingResults(KeyEvent keyEvent) {
        try {
            loadAllRooms(rBO.getMatchingRooms(txtSearch.getText()));
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    public void clearFOrmOnAction(ActionEvent actionEvent) {
        resetFields(txtRoomTypeID, txtRoomType, txtQty, txtKeyMoney);
        btnAddRoom.setText("Add Room");
        btnAddRoom.setDisable(true);
        tblRooms.getSelectionModel().clearSelection();
    }
    public void resetFields(JFXTextField... fields) {
        for (JFXTextField field : fields) {
            field.getParent().setStyle("-fx-border-color :   #EDEDF0;" + "-fx-border-width:1.5;" + "-fx-border-radius:  5;" + "-fx-background-radius:  5;");
            field.clear();
        }
    }

    public void addStudentRoomOnAction(ActionEvent actionEvent) {
    }
}
