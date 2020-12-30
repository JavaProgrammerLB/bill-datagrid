package bill.lau.datagrid.controller;

import bill.lau.datagrid.dao.BookMapper;
import bill.lau.datagrid.entity.BaseResponse;
import bill.lau.datagrid.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    public BookMapper bookMapper;

    @GetMapping("/book/{id}")
    public BaseResponse<Book> getBooksById(@PathVariable Integer id) {
        Book book = bookMapper.findById(id);
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setMsg("Success");
        response.setData(book);
        return response;
    }

    @PostMapping("/book")
    public BaseResponse<String> insertBook(@RequestBody Book book) {
        bookMapper.insert(book);
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setMsg("Success");
        response.setData("Insert Success");
        return response;
    }

    @DeleteMapping("/book/{id}")
    public BaseResponse<String> delete(@PathVariable Integer id) {
        bookMapper.delete(id);
        BaseResponse response = new BaseResponse();
        response.setData("Delete Success");
        response.setMsg("Successs");
        response.setSuccess(true);
        return response;
    }

    @PutMapping("/book")
    public BaseResponse<String> update(@RequestBody Book book) {
        if(book.getId() == null){
            BaseResponse response = new BaseResponse();
            response.setData("ID shouldn't be null");
            response.setMsg("Parameter ERROR");
            response.setSuccess(false);
            return response;
        }
        bookMapper.update(book);
        BaseResponse response = new BaseResponse();
        response.setData("Update Success");
        response.setMsg("Successs");
        response.setSuccess(true);
        return response;
    }

    @PostMapping("/searchBook")
    public BaseResponse<String> findByParam(@RequestBody Book book) {
        List<Book> books = bookMapper.findByParam(book);
        BaseResponse response = new BaseResponse();
        response.setData(books);
        response.setMsg("Success");
        response.setSuccess(true);
        return response;
    }

}
