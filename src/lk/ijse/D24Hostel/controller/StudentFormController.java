package lk.ijse.D24Hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24Hostel.bo.BOFactory;
import lk.ijse.D24Hostel.view.tm.StudentTM;

import java.io.IOException;

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

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void saveStudentOnAction(ActionEvent actionEvent) {
    }

    public void backToDashboardbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"));
        Stage stage = (Stage) StudentForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }
}
