package com.mgv.libraryserver.backend.books.infrastructure;

import com.mgv.libraryserver.backend.books.domain.Book;
import com.mgv.libraryserver.backend.books.domain.BookRepository;
import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import com.mgv.libraryserver.backend.books.infrastructure.dao.BookDao;
import com.mgv.libraryserver.backend.books.infrastructure.dao.BookRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MySqlBookRepository implements BookRepository {
    private static Logger LOG = Logger.getLogger(String.valueOf(MySqlBookRepository.class));

    @Autowired
    private BookMapper mapper;
    @Autowired
    private BookRepositoryDao repositoryDao;

    @Override
    public void save(Book book) {
        BookDao dao = mapper.book2Dao(
                book.uuid().value(),
                book.title().value(),
                book.author().value(),
                book.genre().value(),
                book.editorial().value(),
                book.bookId().value(),
                book.internalId().value(),
                book.booking().value()
        );
        repositoryDao.save(dao);
    }

    @Override
    public Optional<Book> searchById(BookUuid uuid) {
        Optional<BookDao> optBook = repositoryDao.findById(uuid.value());
        return optBook.map(dao -> mapper.dao2Book(dao));
    }

    @Override
    public List<Book> findAll() {
        return repositoryDao.findAll().stream().map(p -> mapper.dao2Book(p)).collect(Collectors.toList());
    }

    @Override
    public void delete(BookUuid uuid) {
        repositoryDao.deleteById(uuid.value());
    }
}
