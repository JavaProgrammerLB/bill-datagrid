package bill.lau.datagrid.dao;

import bill.lau.datagrid.entity.Book;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class BoolSqlProvider implements ProviderMethodResolver {

    public static String findByParam(Book book) {
        Integer id = book.getId();
        String name = book.getName();
        String press = book.getPress();
        return new SQL() {
            {
                SELECT("*");
                FROM("book");
                if (id != null) {
                    WHERE("id = #{id}");
                }
                if (StringUtils.isNotBlank(name)) {
                    WHERE("name like concat('%', #{name}, '%')");
                }
                if (StringUtils.isNotBlank(press)) {
                    WHERE("press like concat('%', #{press}, '%')");
                }
                ORDER_BY("id");
            }
        }.toString();
    }
}
