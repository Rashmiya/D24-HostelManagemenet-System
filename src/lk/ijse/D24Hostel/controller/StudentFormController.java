package lk.ijse.D24Hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.D24Hostel.bo.BOFactory;
import lk.ijse.D24Hostel.bo.custom.StudentBo;
import lk.ijse.D24Hostel.dto.StudentDTO;
import lk.ijse.D24Hostel.view.tm.StudentTM;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class StudentFormController {

    public AnchorPane StudentForm;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXComboBox<String> cmbGender;
    public TableView<StudentTM> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNumber;
    public TableColumn colDOB;
    public TableColumn colGender;
    public Button btnSave;
    public Button btnDelete;
    public TextField txtSearch;
    public JFXDatePicker datePickerDOB;

    StudentBo studentBO = (StudentBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize() throws IOException {

        cmbGender.getItems().addAll("Male","Female");

        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sId"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));

        /*initUI();*/

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnDelete.setDisable(false);

            if(newValue != null){
                txtId.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtContact.setText(newValue.getContactNumber());
                datePickerDOB.setValue(newValue.getDob());
                cmbGender.setValue(newValue.getGender());

                txtId.setDisable(false);
                txtName.setDisable(false);
                txtAddress.setDisable(false);
                txtContact.setDisable(false);
                datePickerDOB.setDisable(false);
                cmbGender.setDisable(false);

                btnSave.setDisable(false);
            }
        });

        loadAllStudents();
    }

    private void loadAllStudents() {
        tblStudent.getItems().clear();
        try {

            List<StudentDTO> allStudents = studentBO.getAllStudent();

            for(StudentDTO studentDTO : allStudents) {
                tblStudent.getItems().add(new StudentTM(
                        studentDTO.getId(),
                        studentDTO.getName(),
                        studentDTO.getAddress(),
                        studentDTO.getContactNumber(),
                        studentDTO.getDob(),
                        studentDTO.getGender()));
            }
        } catch (Exception e) {
/*
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
*/
            e.printStackTrace();
        }
    }


    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {
        StudentTM selectedItem = tblStudent.getSelectionModel().getSelectedItem();

        try {
            if (studentBO.deleteStudent(selectedItem.getId())) {
                Notifications notify = Notifications.create();
                notify.title("Student Deleted !");
                notify.text(" You Successfully Deleted Student.");
                notify.graphic(null);
                notify.hideAfter(Duration.seconds(7));
                notify.position(Pos.BOTTOM_RIGHT);
                notify.showConfirm();

                /*initUI();*/
                loadAllStudents();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Went Wrong !!").show();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveStudentOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        LocalDate dob = datePickerDOB.getValue();
        String gender = cmbGender.getValue();

        if (!id.matches("^(S00)[0-9]{1,5}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid ID").show();
            txtId.requestFocus();
            return;

        }else if (!name.matches("[A-Za-z ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtName.requestFocus();
            return;
        } else if (!address.matches("^[A-z0-9 ,/]{4,20}$")) {
            new Alert(Alert.AlertType.ERROR, "Address should be at least 3 characters long").show();
            txtAddress.requestFocus();
            return;
        }else if (!contact.matches("^07(7|6|8|1|2|5|0|4)-[0-9]{7}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid city").show();
            txtContact.requestFocus();
            return;
        }
        if (btnSave.getText().equalsIgnoreCase("Save")) {
            /*Save Student*/
            try {
                if (studentBO.saveStudent(new StudentDTO(id, name, address, contact, dob, gender))){

                    Notifications notify = Notifications.create();
                    notify.title("Student Added !");
                    notify.text(" You Successfully Added Student.");
                    notify.graphic(null);
                    notify.hideAfter(Duration.seconds(7));
                    notify.position(Pos.BOTTOM_RIGHT);
                    notify.showConfirm();

                    tblStudent.getItems().add(new StudentTM(id, name, address, contact, dob, gender));
                    clearFields();
                }else{
                    new Alert(Alert.AlertType.ERROR, "Something Went Wrong!.Please Check Again.").show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                /*Update Student*/
                if (studentBO.updateStudent(new StudentDTO(id, name, address, contact, dob, gender))) {

                    Notifications notify = Notifications.create();
                    notify.title("Student Updated !");
                    notify.text(" You Successfully Updated Student.");
                    notify.graphic(null);
                    notify.hideAfter(Duration.seconds(7));
                    notify.position(Pos.BOTTOM_RIGHT);
                    notify.showConfirm();

                    loadAllStudents();
                    clearFields();
                }
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();
            }
        }
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        datePickerDOB.setValue(null);
        cmbGender.setValue(null);
    }

    public void backToDashboardbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"));
        Stage stage = (Stage) StudentForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }
}
