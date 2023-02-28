package com.mgv.libraryserver.backend.bookings.infrastructure;

import com.mgv.libraryserver.backend.bookings.domain.Booking;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingBookId;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUserId;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.backend.bookings.infrastructure.dao.BookingDao;
import com.mgv.libraryserver.backend.bookings.infrastructure.dao.BookingRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MySqlBookingRepository implements BookingRepository {
    private static Logger LOG = Logger.getLogger(String.valueOf(MySqlBookingRepository.class));

    @Autowired
    private BookingMapper mapper;
    @Autowired
    private BookingRepositoryDao repositoryDao;

    @Override
    public void save(Booking booking) {
        BookingDao dao = mapper.booking2Dao(
                booking.uuid().value(),
                booking.userId().value(),
                booking.userName().value(),
                booking.bookId().value(),
                booking.bookTitle().value(),
                booking.bookInternalId().value(),
                booking.startDate().value(),
                booking.endDate().value(),
                booking.returnDate().value()
        );
        repositoryDao.save(dao);
    }

    @Override
    public Optional<Booking> searchById(BookingUuid uuid) {
        Optional<BookingDao> optBooking = repositoryDao.findById(uuid.value());
        return optBooking.map(dao -> mapper.dao2Booking(dao));
    }

    @Override
    public Optional<Booking> searchByUserAndBook(BookingUserId userId, BookingBookId bookId) {
        Optional<BookingDao> optBooking = repositoryDao.findActiveBooking(userId.value(), bookId.value());
        return optBooking.map(dao -> mapper.dao2Booking(dao));
    }

    @Override
    public Optional<Booking> searchByBook(BookingBookId bookId) {
        Optional<BookingDao> optBooking = repositoryDao.findBooked(bookId.value());
        return optBooking.map(dao -> mapper.dao2Booking(dao));
    }

    @Override
    public List<Booking> findByUser(BookingUserId userId) {
        return repositoryDao.findByUser(userId.value()).stream().map(p -> mapper.dao2Booking(p)).collect(Collectors.toList());
    }

    @Override
    public List<Booking> findPendingByUser(BookingUserId userId) {
        return repositoryDao.findPendingByUser(userId.value()).stream().map(p -> mapper.dao2Booking(p)).collect(Collectors.toList());
    }

    @Override
    public List<Booking> findAll() {
        return repositoryDao.findAllBookings().stream().map(p -> mapper.dao2Booking(p)).collect(Collectors.toList());
    }

    @Override
    public List<Booking> findPending() {
        return repositoryDao.findByNotReturned().stream().map(p -> mapper.dao2Booking(p)).collect(Collectors.toList());
    }

    @Override
    public List<Booking> findDelayed(String currentDate) {
        return repositoryDao.findDelayed(currentDate).stream().map(p -> mapper.dao2Booking(p)).collect(Collectors.toList());
    }

    @Override
    public void delete(BookingUuid uuid) {
        repositoryDao.deleteById(uuid.value());
    }


}
