package com.idea.graphqls.api.controller;

import com.idea.graphqls.api.entity.BookClassify;
import com.idea.graphqls.api.ex.Err;
import com.idea.graphqls.api.service.BookClassifyService;
import com.idea.graphqls.api.utils.ControllerUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book-classify")
@AllArgsConstructor
public class BookClassifyController {
    private final BookClassifyService bookClassifyService;

    @PostMapping
    public BookClassify post(@RequestBody @Valid BookClassify bookClassify) {
        return bookClassifyService.insert(bookClassify.getName());
    }

    @DeleteMapping("{id}")
    public BookClassify delete(@PathVariable long id) {
        return ControllerUtils.deleteIfExists("book-classify", id, bookClassifyService::get, bookClassifyService::delete);
    }

    @PutMapping("{id}")
    public BookClassify put(@PathVariable long id, @RequestBody @Valid BookClassify bookClassify) {
        return bookClassifyService.update(id, bookClassify.getName());
    }

    @GetMapping("{id}")
    public BookClassify get(@PathVariable long id) {
        return bookClassifyService.get(id);
    }

    @GetMapping
    public List<BookClassify> list() {
        return bookClassifyService.list();
    }
}
