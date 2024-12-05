package com.company.homeworkhotel.view.room;

import com.company.homeworkhotel.entity.Room;
import com.company.homeworkhotel.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "rooms", layout = MainView.class)
@ViewController("Room.list")
@ViewDescriptor("room-list-view.xml")
@LookupComponent("roomsDataGrid")
@DialogMode(width = "64em")
public class RoomListView extends StandardListView<Room> {
}