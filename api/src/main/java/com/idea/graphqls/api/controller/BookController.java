package com.idea.graphqls.api.controller;

import com.idea.graphqls.api.entity.Book;
import com.idea.graphqls.api.input.BookPageQuery;
import com.idea.graphqls.api.model.Page;
import com.idea.graphqls.api.service.BookService;
import com.idea.graphqls.api.utils.ControllerUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {
    final private BookService bookService;

    @PostMapping
    public Book post(@Valid @RequestBody Book input) {
        return bookService.insert(input);
    }

    @DeleteMapping("{id}")
    public Book delete(@PathVariable long id) {
        return ControllerUtils.deleteIfExists("book", id, bookService::get, bookService::delete);
    }

    @PutMapping("{id}")
    public Book update(@PathVariable long id, @Valid @RequestBody Book input) {
        return bookService.update(id, input);
    }

    @GetMapping("{id}")
    public Book get(@PathVariable long id) {
        return bookService.get(id);
    }

    @GetMapping
    public List<Book> list() {
        return bookService.list();
    }

    @GetMapping(params = "size")
    public Page<Book> page(BookPageQuery query) {
        return bookService.page(query);
    }

}

