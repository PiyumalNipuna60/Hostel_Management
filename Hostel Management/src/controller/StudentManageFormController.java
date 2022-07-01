package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import bo.BOFactory;
import bo.custom.StudentBO;
import dto.StudentDTO;
import view.tdm.StudentTM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class StudentManageFormController {
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public JFXTextField txtStudentId;
    public TableView<StudentTM> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDob;
    public TableColumn colGender;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtName;
    public JFXDatePicker datePDob;
    public JFXComboBox cmbGender;

    public void initialize(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        loadAllStudents();

        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtStudentId.setText(newValue.getStudent_id());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtContactNo.setText(newValue.getContact_no());
            datePDob.setValue(newValue.getDob());
            cmbGender.setValue(newValue.getGender());
        });
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String student_id =txtStudentId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact_no = txtContactNo.getText();
        LocalDate dob = datePDob.getValue();
        String gender = String.valueOf(cmbGender.getValue());
        try {
            if(studentBO.updateStudent(new StudentDTO(student_id,name,address,contact_no,dob,gender))){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated ...!").show();
                StudentTM tm = tblStudent.getSelectionModel().getSelectedItem();
                tm.setStudent_id(student_id);
                tm.setName(name);
                tm.setAddress(address);
                tm.setContact_no(contact_no);
                tm.setDob(dob);
                tm.setGender(gender);
                tblStudent.refresh();
                clearUi();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String sId = txtStudentId.getText();
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to Delete \"" + sId + "\" Student ?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            try {
                if(studentBO.deleteStudent(sId)){
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted ...!").show();
                    tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
                    tblStudent.getSelectionModel().clearSelection();
                    clearUi();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        clearUi();
    }

    private void loadAllStudents(){
        try {
            List<StudentDTO> stuList = studentBO.getAllStudents();
            for (StudentDTO s : stuList) {
                tblStudent.getItems().add(new StudentTM(s.getStudent_id(),s.getName(),s.getAddress(),s.getContact_no(),s.getDob(),s.getGender()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearUi(){
        txtAddress.clear();
        txtContactNo.clear();
        txtName.clear();
        txtStudentId.clear();
    }
}
