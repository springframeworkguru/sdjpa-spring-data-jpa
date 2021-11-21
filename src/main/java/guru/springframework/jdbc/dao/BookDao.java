package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;

import java.util.List;

/**
 * Created by jt on 8/29/21.
 */
public interface BookDao {
    
    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);

}
