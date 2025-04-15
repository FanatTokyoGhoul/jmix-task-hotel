package com.company.homeworkhotel.app;

import com.company.homeworkhotel.entity.Booking;
import com.company.homeworkhotel.entity.Room;
import com.company.homeworkhotel.entity.RoomReservation;
import io.jmix.core.DataManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class BookingService {

    private final DataManager dataManager;
    @PersistenceContext
    private EntityManager entityManager;

    public BookingService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * Check if given room is suitable for the booking.
     * 1) Check that sleeping places is enough to fit numberOfGuests.
     * 2) Check that there are no reservations for this room at the same range of dates.
     * Use javax.persistence.EntityManager and JPQL query for querying database.
     *
     * @param booking booking
     * @param room room
     * @return true if checks are passed successfully
     */
    public boolean isSuitable(Booking booking, Room room) {
        Boolean cantGo = entityManager
                .createQuery("SELECT CASE WHEN count(rr) > 0 THEN true ELSE false END FROM RoomReservation rr " +
                        "where rr.booking.arrivalDate > :bookingArrivalDate and" +
                        " rr.booking.departureDate < :bookingArrivalDate",
                        Boolean.class)
                .setParameter("bookingArrivalDate", booking.getArrivalDate())
                .getSingleResult();
        return booking.getNumberOfGuests() <= room.getSleepingPlaces() && !cantGo;
    }

    /**
     * Check that room is suitable for the booking, and create a reservation for this room.
     * @param room room to reserve
     * @param booking hotel booking
     * Wrap operation into a transaction (declarative or manual).
     *
     * @return created reservation object, or null if room is not suitable
     */
    public RoomReservation reserveRoom(Booking booking, Room room) {
        //todo implement me!
        return null;
    }
}