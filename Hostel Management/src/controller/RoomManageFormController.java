package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import bo.BOFactory;
import bo.custom.RoomBO;
import dto.RoomDTO;
import view.tdm.RoomTM;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoomManageFormController {
    public TableView<RoomTM> tblRoom;
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomsQty;
    public TableColumn colDelete;
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXButton btnSave;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void initialize() {
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colRoomsQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadAllRooms();

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtRoomTypeId.setText(newValue.getRoom_type_id());
            txtType.setText(newValue.getType());
            txtKeyMoney.setText(newValue.getKey_money());
            txtRoomQty.setText(String.valueOf(newValue.getQty()));
            if (newValue != null) {
                btnSave.setText("Update");
            }
        });
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        clearUI();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String typeId = txtRoomTypeId.getText();
        String type = txtType.getText();
        String keyMoney = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtRoomQty.getText());

        if (btnSave.getText().equalsIgnoreCase("save")) {
            try {
                if (roomBO.saveRooms(new RoomDTO(typeId, type, keyMoney, qty))) {
                    tblRoom.getItems().add(new RoomTM(typeId, type, keyMoney, qty));
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved... !").show();
                    clearUI();
                    tblRoom.refresh();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (btnSave.getText().equalsIgnoreCase("update")) {
            try {
                if (roomBO.updateRooms(new RoomDTO(typeId, type, keyMoney, qty))) {
                    RoomTM tm = tblRoom.getSelectionModel().getSelectedItem();
                    tm.setRoom_type_id(typeId);
                    tm.setType(type);
                    tm.setKey_money(keyMoney);
                    tm.setQty(qty);
                    tblRoom.refresh();
                    clearUI();
                    btnSave.setText("Save");
                    new Alert(Alert.AlertType.CONFIRMATION, "Updated... !").show();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String typeId = txtRoomTypeId.getText();
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to Delete \"" + typeId + "\" RoomType ?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)) {}
        try {
            if(roomBO.deleteRoom(typeId)){
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Deleted !").show();
                tblRoom.getItems().remove(tblRoom.getSelectionModel().getSelectedItem());
                tblRoom.getSelectionModel().clearSelection();
                btnSave.setText("Save");
                clearUI();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        private void loadAllRooms () {
            try {
                List<RoomDTO> allRooms = roomBO.getAllRooms();
                for (RoomDTO room : allRooms) {
                    tblRoom.getItems().add(new RoomTM(room.getRoom_type_id(), room.getType(), room.getKey_money(), room.getQty()));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void clearUI () {
            txtKeyMoney.clear();
            txtRoomQty.clear();
            txtRoomTypeId.clear();
            txtType.clear();
        }
}
