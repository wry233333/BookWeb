package net.f3322.wry333.service;

import net.f3322.wry333.Dao.BookDao;
import net.f3322.wry333.domain.Book;

import java.util.List;

public class BookControlImp implements BookControl{
    @Override
    public List<Book> findAllBook() {
        BookDao bookDao = new BookDao();
        return bookDao.findAllBooks();
    }
}
