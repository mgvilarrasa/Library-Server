package com.mgv.libraryserver.backend.bookings.domain;

import com.mgv.libraryserver.backend.bookings.domain.vo.BookingBookId;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUserId;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    void save(Booking booking);
    Optional<Booking> searchById(BookingUuid uuid);
    Optional<Booking> searchByUserAndBook(BookingUserId userId, BookingBookId bookId);
    Optional<Booking> searchByBook(BookingBookId bookId);
    List<Booking> findByUser(BookingUserId userId);
    List<Booking> findAll();
    List<Booking> findPending();
    List<Booking> findPendingByUser(BookingUserId userId);
    List<Booking> findDelayed(String currentDate);
    void delete(BookingUuid uuid);
    void deleteAll();
}
