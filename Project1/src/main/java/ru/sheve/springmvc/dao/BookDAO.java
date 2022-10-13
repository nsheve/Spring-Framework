package ru.sheve.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sheve.springmvc.model.Book;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Метод вывода всех книг
    public List<Book> show() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    //Метод вывода по индексу
    public Book index(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    //Метод добавления
    public void save(Book newBook) {
        jdbcTemplate.update("INSERT INTO book (nameBook, author, year) VALUES (?, ?, ?)",
                newBook.getNameBook(), newBook.getAuthor(), newBook.getYear());
    }

    //Метод обновления
    public void update(Book updateBook, int id) {
        jdbcTemplate.update("UPDATE book SET nameBook=?, author=?, year=? WHERE book_id=?",
            updateBook.getNameBook(), updateBook.getAuthor(), updateBook.getYear(), id);
    }

    //Метод удаления
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?", id);
    }
}
