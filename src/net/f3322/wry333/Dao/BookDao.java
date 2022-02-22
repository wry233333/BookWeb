package net.f3322.wry333.Dao;

import net.f3322.wry333.domain.Book;
import net.f3322.wry333.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 添加图书的方法
     * @param book 图书对象
     * @return Boolean 返回插入状态
     */
    public boolean insertBook(Book book){
        String sql = "insert into book(name,publisher,info,auther,price,cls,cover) values(?,?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, book.getName(), book.getPublisher(), book.getInfo(), book.getPrice(), book.getCls(), book.getCover());
        if(i == 0) {
            return false;
        }
        else {
            return true;
        }
    }


    public List<Book> findAllBooks(){
        String sql = "select * from book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }
}
