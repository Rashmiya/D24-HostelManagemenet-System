package lk.ijse.D24Hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.ijse.D24Hostel.bo.BOFactory;
import lk.ijse.D24Hostel.bo.custom.ReservationBO;
import lk.ijse.D24Hostel.bo.custom.RoomBo;
import lk.ijse.D24Hostel.dto.RoomDTO;
import lk.ijse.D24Hostel.view.tm.ReservationTM;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;

public class ReservationFormController {
    public AnchorPane ReservationForm;
    public JFXTextField txtStudentName;
    public JFXComboBox<String> cmbStudentID;
    public JFXComboBox<String> cmbRoomID;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public Text lblRoomId;
    public Text lblRoomType;
    public Label lblRoomQty;
    public Label lblReservationID;
    public JFXTextField txtRoomStatus;
    public JFXTextField txtQty;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnAddToRemain;
    public TableView<ReservationTM> tblReservation;
    public TableColumn colID;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colQty;
    public TableColumn colKeyMoney;
    public TableColumn colStatus;
    public TableColumn colModify;
    String reservationId;
    int PQty;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESERVATION);
    RoomBo roomBO = (RoomBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);

    public void initialize() {
        IdGenerate();

        tblReservation.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("reservationID"));
        tblReservation.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("roomID"));
        tblReservation.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("roomType"));
        tblReservation.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Qty"));
        tblReservation.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblReservation.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("status"));
        TableColumn<ReservationTM, Button> lastCol = (TableColumn<ReservationTM, Button>) tblReservation.getColumns().get(6);
        lastCol.setCellValueFactory(param -> {
            Button btnDelete = new Button("Delete");
            btnDelete.setOnAction(event -> {
                if(tblReservation.getSelectionModel().getSelectedItem()!=null){
                    try {
                        if(ReservationBO.deleteReservation(reservationId)){
                            Notifications notify = Notifications.create();
                            notify.title("Deleted!");
                            notify.text(" You Successfully deleted.");
                            notify.graphic(null);
                            notify.hideAfter(Duration.seconds(7));
                            notify.position(Pos.BOTTOM_RIGHT);
                            notify.showConfirm();

                            //ReservationDTO reservationDTO = purchaseReserveBO.searchReservation(lblReserveID.getText());
                            //  Room roomID = reservationDTO.getRoomID();
                            System.out.println("qry room: "+PQty);

                            RoomDTO roomDTO1 = ReservationBO.searchRooms((String) cmbRoomID.getValue());

                            roomDTO1.setQty(PQty);

                            roomBO.updateRoom(roomDTO1);

                            tblReservation.getItems().remove(param.getValue());
                            tblReservation.getSelectionModel().clearSelection();
                            clearFields();

                        }else {

                            new Alert(Alert.AlertType.ERROR,"Try Again.....").show(); ;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR,"Please Select Row....").show(); ;
                }








            });

            return new ReadOnlyObjectWrapper<>(btnDelete);
        });

        try {
            loadAllReservation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadStudentIds();
        loadRoomIds();

        cmbStudentID.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            try {
                StudentDTO studentDTO = purchaseReserveBO.searchStudent((String) newValue);
                txtStudentName.setText(studentDTO.getStudentName());
            } catch (SQLException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        cmbRoomID.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            try {
                RoomDTO roomDTO = purchaseReserveBO.searchRooms((String) newValue);
                lblRoomId.setText(roomDTO.getRoomID());
                lblRoomType.setText(roomDTO.getRoomType());
                lblRoomQty.setText(String.valueOf(roomDTO.getRoomQty()));

                txtRoomType.setText(roomDTO.getRoomType());
                txtRoomQty.setText((String.valueOf(roomDTO.getRoomQty())));
                txtKeyMoney.setText(roomDTO.getKeyMoney());
            } catch (SQLException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));



        public void AddToRemainOnAction(ActionEvent actionEvent) {
    }

    public void updateReservationOnAction(ActionEvent actionEvent) {
    }

    public void saveReservationOnAction(ActionEvent actionEvent) {
    }

    public void backToDashboardbtnOnAction(ActionEvent actionEvent) {
    }
}

    private void IdGenerate() {
         reservationId = generateNewOrderId();
        lblReservationID.setText(reservationId);
    }

    private String generateNewOrderId() {
        try {
            return ReservationBO.generateNewOrderID();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        new Alert(Alert.AlertType.ERROR, "Failed to generate a new order id").show();
        return "R001";
    }
    }
}
