package lk.ijse.D24Hostel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane DashboardForm;

    public void checkAvailableRoomsOnaction(ActionEvent actionEvent) {
    }

    public void manageStudentbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/StudentForm.fxml"));
        Stage stage = (Stage) DashboardForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void manageStudents(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("lk/ijse/D24Hostel/view/StudentForm.fxml"));
        Stage stage = (Stage) DashboardForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void LogOutbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));
        Stage stage = (Stage) DashboardForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void manageRoomsbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/RoomForm.fxml"));
        Stage stage = (Stage) DashboardForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void manageRooms(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/RoomForm.fxml"));
        Stage stage = (Stage) DashboardForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void RoomReservationbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml"));
        Stage stage = (Stage) DashboardForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void RoomReservation(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml"));
        Stage stage = (Stage) DashboardForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void checkAvailableRooms(MouseEvent mouseEvent) {

    }
}
