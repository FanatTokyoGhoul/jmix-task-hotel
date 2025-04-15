package com.company.homeworkhotel.listener;

import com.company.homeworkhotel.entity.Booking;
import com.company.homeworkhotel.entity.BookingStatus;
import com.company.homeworkhotel.entity.RoomReservation;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.SaveContext;
import io.jmix.core.event.AttributeChanges;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Component
public class BookingEventListener {
    private final DataManager dataManager;

    public BookingEventListener(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @EventListener
    public void onBookingSaving(final EntitySavingEvent<Booking> event) {
        Booking booking = event.getEntity();
        booking.setDepartureDate(booking.getArrivalDate().plusDays(booking.getNightsOfStay()));
    }

    @EventListener
    public void onBookingChangedBeforeCommit(final EntityChangedEvent<Booking> event) {
        AttributeChanges changes = event.getChanges();

        if (changes.isChanged("status")) {
            Booking booking = dataManager.load(event.getEntityId()).one();
            if (booking.getStatus() == BookingStatus.CANCELLED) {
                List<RoomReservation> roomList = dataManager.load(RoomReservation.class)
                        .query("select r from RoomReservation r where r.booking.id = :bookingId")
                        .joinTransaction(true)
                        .parameter("bookingId", booking.getId())
                        .list();

                dataManager.save(
                        new SaveContext()
                                .removing(roomList)
                                .setJoinTransaction(true)
                );
            }
        }
    }
}