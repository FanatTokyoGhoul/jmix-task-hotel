package com.company.homeworkhotel.view.roomreservation;

import com.company.homeworkhotel.entity.Client;
import com.company.homeworkhotel.entity.RoomReservation;
import com.company.homeworkhotel.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.flowui.Dialogs;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "reserved-rooms", layout = MainView.class)
@ViewController("ReservedRooms.list")
@ViewDescriptor("reserved-rooms-list.xml")
@LookupComponent("roomReservationsDataGrid")
@DialogMode(width = "64em")
public class ReservedRoomsList extends StandardListView<RoomReservation> {
    @ViewComponent
    private DataGrid<RoomReservation> roomReservationsDataGrid;
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private DataManager dataManager;

    @Subscribe("roomReservationsDataGrid.viewClientEmail")
    public void onRoomReservationsDataGridViewClientEmail(final ActionPerformedEvent event) {
        RoomReservation reservation = roomReservationsDataGrid.getSingleSelectedItem();
        if (reservation == null) {
            return;
        }
        Client client = reservation.getBooking().getClient();

        String email = dataManager.load(Id.of(client.getId(), Client.class))
                .one().getEmail();

        dialogs.createMessageDialog()
                .withHeader("Client email")
                .withText(email)
                .open();
    }
}