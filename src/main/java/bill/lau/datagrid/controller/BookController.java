package bill.lau.datagrid.controller;

import bill.lau.datagrid.dao.BookMapper;
import bill.lau.datagrid.entity.BaseResponse;
import bill.lau.datagrid.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        bookMapper.update(book);
        BaseResponse response = new BaseResponse();
        response.setData("Delete Success");
        response.setMsg("Successs");
        response.setSuccess(true);
        return response;
    }

    @PostMapping("/searchBook")
    public BaseResponse<String> findByParam(@RequestBody Book book) {
        bookMapper.findByParam(book);
        BaseResponse response = new BaseResponse();
        response.setData("Query Success");
        response.setMsg("Success");
        response.setSuccess(true);
        return response;
    }

}
