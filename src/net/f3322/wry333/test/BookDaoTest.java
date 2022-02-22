package net.f3322.wry333.test;

import net.f3322.wry333.Dao.BookDao;
import net.f3322.wry333.domain.Book;
import org.junit.Test;

import java.util.List;

public class BookDaoTest {
    /**
     * 测试查询全部书籍的功能
     */
    @Test
    public void testBookDao(){
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.findAllBooks();
        for (Book b: books) {
            System.out.println(b.toString());
        }
    }
}
