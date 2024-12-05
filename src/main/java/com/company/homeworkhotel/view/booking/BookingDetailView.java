package com.company.homeworkhotel.view.booking;

import com.company.homeworkhotel.entity.Booking;
import com.company.homeworkhotel.entity.BookingStatus;
import com.company.homeworkhotel.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bookings/:id", layout = MainView.class)
@ViewController("Booking.detail")
@ViewDescriptor("booking-detail-view.xml")
@EditedEntityContainer("bookingDc")
public class BookingDetailView extends StandardDetailView<Booking> {
    @Subscribe
    public void onInitEntity(final InitEntityEvent<Booking> event) {
        event.getEntity().setStatus(BookingStatus.BOOKED);
    }
}