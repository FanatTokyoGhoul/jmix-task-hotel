package com.company.homeworkhotel.view.client;

import com.company.homeworkhotel.entity.Client;
import com.company.homeworkhotel.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "clients", layout = MainView.class)
@ViewController("Client.list")
@ViewDescriptor("client-list-view.xml")
@LookupComponent("clientsDataGrid")
@DialogMode(width = "64em")
public class ClientListView extends StandardListView<Client> {
}