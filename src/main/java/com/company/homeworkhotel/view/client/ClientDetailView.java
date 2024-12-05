package com.company.homeworkhotel.view.client;

import com.company.homeworkhotel.entity.Client;
import com.company.homeworkhotel.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "clients/:id", layout = MainView.class)
@ViewController("Client.detail")
@ViewDescriptor("client-detail-view.xml")
@EditedEntityContainer("clientDc")
public class ClientDetailView extends StandardDetailView<Client> {
}