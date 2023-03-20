package com.mgv.libraryserver.console.loader.application;

import com.mgv.libraryserver.backend.books.domain.Book;
import com.mgv.libraryserver.backend.books.domain.BookRepository;
import com.mgv.libraryserver.backend.books.domain.vo.*;
import com.mgv.libraryserver.console.loader.domain.EmptyFile;
import com.mgv.libraryserver.console.loader.domain.FileNotLoaded;
import com.mgv.libraryserver.shared.utils.UuidGenerator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class XlsxBookLoader {
    private static Logger LOG = Logger.getLogger(String.valueOf(XlsxBookLoader.class));

    private final UuidGenerator generator;
    private final BookRepository bookRepository;

    public XlsxBookLoader(
            UuidGenerator generator,
            BookRepository bookRepository
    ){
        this.generator = generator;
        this.bookRepository = bookRepository;
    }

    public void loadBooksFromXlsxFile(MultipartFile booksFile) throws FileNotLoaded, EmptyFile {
        try{
            DataFormatter formatter = new DataFormatter();
            FileInputStream file = new FileInputStream(multipartToFile(booksFile));
            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();

            if(totalRows == 0){
                throw new EmptyFile();
            }

            List<Book> books = new ArrayList<>();

            for (int rowNum=1; rowNum<=totalRows; rowNum++) {
                List<String> attributes = new ArrayList<>();
                boolean emptyRow = false;
                Row row = sheet.getRow(rowNum);

                if(row == null) {
                    if(rowNum == 1) {
                        throw new EmptyFile();
                    }
                }
                else{
                    Cell cell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if(formatter.formatCellValue(cell).isEmpty()){
                        emptyRow = true;
                    } else {
                        attributes.add(String.valueOf(formatter.formatCellValue(cell)));

                        for(int i=1; i<5; i++){
                            cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                            if(formatter.formatCellValue(cell).isEmpty()){
                                attributes.add(null);
                            } else{
                                attributes.add(String.valueOf(formatter.formatCellValue(cell)));
                            }
                        }
                        books.add(createBook(attributes));
                    }
                }
            }

            saveBooks(books);
        } catch (Exception e){
            e.printStackTrace();
            throw new FileNotLoaded();
        }

    }

    private Book createBook(List<String> attributes){
        BookUuid uuid = new BookUuid(generator.generate());
        BookTitle title = new BookTitle(attributes.get(0));
        BookAuthor author = new BookAuthor(attributes.get(1));
        BookGenre genre = new BookGenre(attributes.get(2));
        BookEditorial editorial = new BookEditorial(attributes.get(3));
        BookId bookId = new BookId(attributes.get(4));

        return Book.create(uuid, title, author, genre, editorial, bookId, new BookInternalId(null), new BookBooking(null));
    }

    private void saveBooks(List<Book> books) {
        for(Book book: books) {
            bookRepository.save(book);
        }
    }

    private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(multipart.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipart.getBytes());
        fos.close();
        return convFile;
    }
}
