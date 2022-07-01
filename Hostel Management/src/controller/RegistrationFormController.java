package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;
import bo.BOFactory;
import bo.custom.RegistrationBO;
import bo.custom.RoomBO;
import dao.custom.RoomDAO;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class RegistrationFormController {

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    RegistrationBO regBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);

    public JFXTextField txtAddress;
    public Label lblRsId;
    public JFXTextField txtName;
    public Label lblTime;
    public Label lblDate;
    public JFXTextField txtStudentId;
    public JFXTextField btnName;
    public JFXTextField btnAddress;
    public JFXTextField txtContactNo;
    public JFXComboBox cmbGender;
    public JFXDatePicker dPickDob;
    public JFXComboBox cmbRoomType;
    public JFXDatePicker dPickRegistrationDate;
    public JFXComboBox cmbPaymentType;
    public JFXTextField txtAmount;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomTypeId;

    public void initialize(){
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        cmbPaymentType.getItems().add("Pay Now");
        cmbPaymentType.getItems().add("Pay Later");
        cmbPaymentType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("Pay Later")){
                txtAmount.setText("Pending");
                txtAmount.setEditable(false);
            }
        });

        loadRoomTypes();

        loadDateAndTime();

        cmbRoomType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String type = (String) newValue;
            try {
                List<RoomDTO> roomDto= getRoomID(type);
                for (RoomDTO r : roomDto) {
                    txtRoomTypeId.setText(r.getRoom_type_id());
                    txtRoomTypeId.setEditable(false);
                    txtKeyMoney.setText(r.getKey_money());
                    txtKeyMoney.setEditable(false);
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        lblRsId.setText(generateNewOrderId());
    }

    private void loadDateAndTime() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, event ->{
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour()+":"+currentTime.getMinute()+":"+currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void loadRoomTypes(){
        try {
            List<String> roomTypes = roomBO.getRoomTypes();
            for (String roomType : roomTypes) {
                cmbRoomType.getItems().add(roomType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<RoomDTO> getRoomID(String type) throws SQLException, ClassNotFoundException {
        List<RoomDTO> roomDetail = roomBO.getRoomId(type);
        return roomDetail;
    }

    public String generateNewOrderId(){
        try {
            return regBO.generateNewOrderID();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "RID001";
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        String sId=txtStudentId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        LocalDate dob = dPickDob.getValue();
        String gender = (String) cmbGender.getValue();

        StudentDTO studentDTO = new StudentDTO(sId,name,address,contactNo,dob,gender);

        String roomTypeId = txtRoomTypeId.getText();
        String type = (String)cmbRoomType.getValue();
        String keyMoney = txtKeyMoney.getText();
        int qty = 1;

        RoomDTO roomDTO = new RoomDTO(roomTypeId,type,keyMoney,qty);

        String rsId = lblRsId.getText();
        LocalDate resDate = dPickRegistrationDate.getValue();
        String status = txtAmount.getText();

        ReservationDTO reservationDTO = new ReservationDTO(rsId,resDate,status);

        reserveRoom(studentDTO,roomDTO,reservationDTO);

    }

    private Boolean reserveRoom(StudentDTO stDTO, RoomDTO roomDTO, ReservationDTO resDTO) {
        try {
            return regBO.reserveRoom(stDTO,roomDTO,resDTO);
        } catch (SQLException e1) {
            e1.printStackTrace();
            new Alert(Alert.AlertType.WARNING, e1.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        return true;
    }

}
