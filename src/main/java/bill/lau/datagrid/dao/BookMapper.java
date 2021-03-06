package bill.lau.datagrid.dao;

import bill.lau.datagrid.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert("INSERT INTO book(name, press) VALUES(#{name}, #{press})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Book book);

    @Select("SELECT id, name, press FROM book WHERE id = #{id}")
    Book findById(Integer id);

    @Delete("DELETE FROM book WHERE id = #{id}")
    void delete(Integer id);

    @Update("UPDATE book SET name = #{name}, press = #{press} WHERE id = #{id}")
    void update(Book book);

    @SelectProvider(BoolSqlProvider.class)
    List<Book> findByParam(Book book);

    @Select("SELECT * FROM book")
    List<Book> getAllBooks();
}
