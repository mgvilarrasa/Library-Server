package com.mgv.libraryserver.backend.bookings.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepositoryDao extends JpaRepository<BookingDao, String> {
    @Query(value = "SELECT * FROM bookings WHERE user_id = ?1 AND book_id = ?2 AND (return_date IS NULL OR return_date = '') LIMIT 1", nativeQuery = true)
    Optional<BookingDao> findActiveBooking(String userId, String bookId);
    @Query(value = "SELECT * FROM bookings WHERE book_id = ?1 AND (return_date IS NULL OR return_date = '') LIMIT 1", nativeQuery = true)
    Optional<BookingDao> findBooked(String bookId);
    @Query(value = "SELECT * FROM bookings WHERE user_id = ?1", nativeQuery = true)
    List<BookingDao> findByUser(String userId);
    @Query(value = "SELECT * FROM bookings WHERE return_date IS NULL OR return_date = ''", nativeQuery = true)
    List<BookingDao> findByNotReturned();
    @Query(value = "SELECT * FROM bookings WHERE user_id = ?1 AND (return_date IS NULL OR return_date = '')", nativeQuery = true)
    List<BookingDao> findPendingByUser(String userId);
    @Query(value = "SELECT * FROM bookings ORDER BY return_date ASC", nativeQuery = true)
    List<BookingDao> findAllBookings();
    @Query(value = "SELECT * FROM bookings WHERE end_date < ?1 AND (return_date IS NOT NULL OR return_date != '')", nativeQuery = true)
    List<BookingDao> findDelayed(String currentDate);
}
