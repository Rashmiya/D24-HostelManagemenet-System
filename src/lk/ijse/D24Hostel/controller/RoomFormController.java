package lk.ijse.D24Hostel.controller;

import com.jfoenix.controls.JFXComboBox;
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
import lk.ijse.D24Hostel.bo.custom.RoomBo;
import lk.ijse.D24Hostel.dto.RoomDTO;
import lk.ijse.D24Hostel.view.tm.RoomTM;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.util.List;

public class RoomFormController {
    public AnchorPane RoomForm;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXComboBox<String> cmbRoomID;
    public JFXComboBox<String> cmbRoomType;
    public TableView<RoomTM> tblRoom;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public Button btnSave;
    public Button btnDelete;
    public TextField txtSearch;

    RoomBo roomBO = (RoomBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);

    public void initialize(){
        cmbRoomID.getItems().addAll("RM-1324","RM-5467","RM-7896","RM-0093");
        cmbRoomType.getItems().addAll("Non-AC","Non-Ac/Food","AC","AC/Food");

        tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("roomType"));
        tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));

        /*initUI();*/

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnDelete.setDisable(false);

            if(newValue != null){
                cmbRoomID.setValue(newValue.getRoomId());
                cmbRoomType.setValue(newValue.getRoomType());
                txtKeyMoney.setText(newValue.getKeyMoney());
                txtRoomQty.setText(String.valueOf(newValue.getQty()));
                
                cmbRoomID.setDisable(false);
                cmbRoomType.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtRoomQty.setDisable(false);
                
                btnSave.setDisable(false);
            }
        });
        loadAllRooms();
    }

    private void loadAllRooms() {
        tblRoom.getItems().clear();
        try {
            List<RoomDTO> allrooms = roomBO.getAllRooms();

            for(RoomDTO roomDTO : allrooms) {
                tblRoom.getItems().add(new RoomTM(
                        roomDTO.getRoomId(),
                        roomDTO.getRoomType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));
            }
        } catch (Exception e) {
          /*  new Alert(Alert.AlertType.ERROR, e.getMessage()).show();*/
            e.printStackTrace();
        }
    }

    private void clearFields(){
        cmbRoomID.setValue(null);
        cmbRoomType.setValue(null);
        txtKeyMoney.clear();
        txtRoomQty.clear();
    }
    public void backToDashboardbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/RoomForm.fxml"));
        Stage stage = (Stage) RoomForm.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void saveRoomOnAction(ActionEvent actionEvent) {
        String id =cmbRoomID.getValue();
        String type = cmbRoomType.getValue();
        String keyMoney = txtKeyMoney.getText();
        int qty = Integer.valueOf(txtRoomQty.getText());

        if (!keyMoney.matches("^[0-9]{3,5}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Key_Money").show();
            txtKeyMoney.requestFocus();
            return;
        } else if (!txtRoomQty.getText().matches("^[0-9]{1,5}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid qty ").show();
            txtRoomQty.requestFocus();
            return;

        }
        if (btnSave.getText().equalsIgnoreCase("Save")) {
            /*Save Room*/
            try {
                if (roomBO.saveRoom(new RoomDTO(id, type, keyMoney, qty)))
                {
                    Notifications notify = Notifications.create();
                    notify.title("Room Saved !");
                    notify.text(" You Successfully Saved a Room");
                    notify.graphic(null);
                    notify.hideAfter(Duration.seconds(7));
                    notify.position(Pos.BOTTOM_RIGHT);
                    notify.showConfirm();

                    tblRoom.getItems().add(new RoomTM(id, type, keyMoney, qty));
                    clearFields();
                }else{
                    new Alert(Alert.AlertType.ERROR, "Something Went Wrong!.Please Check Again").show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                /*Update Room*/
                if (roomBO.updateRoom(new RoomDTO(id, type, keyMoney, qty))) {

                    Notifications notify = Notifications.create();
                    notify.title("Room Updated !");
                    notify.text(" You Successfully Updated a Room");
                    notify.graphic(null);
                    notify.hideAfter(Duration.seconds(7));
                    notify.position(Pos.BOTTOM_RIGHT);
                    notify.showConfirm();

                    loadAllRooms();
                    clearFields();
                }
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!.Please Check Again.").show();
            }
        }
    }

    public void deleteRoomOnAction(ActionEvent actionEvent) {
        String id=tblRoom.getSelectionModel().getSelectedItem().getRoomId();
        try {
            /*Delete A Room*/
            roomBO.deleteRoom(id);

            tblRoom.getItems().remove(tblRoom.getSelectionModel().getSelectedItem());
            Notifications notify = Notifications.create();
            notify.title("Room Deleted !");
            notify.text(" You Successfully Deleted a Room");
            notify.graphic(null);
            notify.hideAfter(Duration.seconds(7));
            notify.position(Pos.BOTTOM_RIGHT);
            notify.showConfirm();

            tblRoom.getSelectionModel().clearSelection();
            clearFields();
        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Something Happened.Try again!").show();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
