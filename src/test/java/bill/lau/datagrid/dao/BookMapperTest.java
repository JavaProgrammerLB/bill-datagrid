package bill.lau.datagrid.dao;

import bill.lau.datagrid.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = NONE)
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Before
    public void setup(){
        // insert
        Book book = new Book();
        book.setName("Java8实战");
        book.setPress("人民邮电出版社");
        bookMapper.insert(book);
    }

    @Test
    public void test() {
        Book book = new Book();
        book.setName("Java8实战");
        book.setPress("人民邮电出版社");

        // findById
        Book book1 = bookMapper.findById(1);
        assertEquals(book.getName(), book1.getName());
        assertEquals(book.getPress(), book1.getPress());

        // udpate
        Book book2 = new Book();
        book2.setId(1);
        book2.setName("JAVA8实战");
        book2.setPress("人民邮电出版社");
        bookMapper.update(book2);

        // findById
        Book book3 = bookMapper.findById(1);
        assertEquals(book3.getName(), book2.getName());
        assertEquals(book3.getPress(), book3.getPress());

        // delete
        bookMapper.delete(1);
        Book book4 = bookMapper.findById(1);
        assertTrue(book4 == null);

        // insert
        Book book5 = new Book();
        book5.setName("Java8实战");
        book5.setPress("人民邮电出版社");
        bookMapper.insert(book5);

        // findById
        Book book6 = bookMapper.findById(2);
        assertEquals(book5.getName(), book6.getName());
        assertEquals(book5.getPress(), book6.getPress());
    }

    @Test
    public void findByParam() {
        Book book = new Book();
        book.setName("实战");
        List<Book> books = bookMapper.findByParam(book);
        assertTrue(books.size() > 0);
        assertEquals("Java8实战", books.get(0).getName());
    }

    @Test
    public void findByParam3(){
        Book book = new Book();
        book.setPress("出版社");
        List<Book> books = bookMapper.findByParam(book);
        assertTrue(books.size() > 0);
        assertEquals("Java8实战", books.get(0).getName());
        assertEquals("人民邮电出版社", books.get(0).getPress());
    }
}