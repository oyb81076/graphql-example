package com.idea.graphqls.api.controller;

import com.idea.graphqls.api.entity.Author;
import com.idea.graphqls.api.input.AuthorPageQuery;
import com.idea.graphqls.api.model.Page;
import com.idea.graphqls.api.service.AuthorService;
import com.idea.graphqls.api.utils.ControllerUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/author")
@AllArgsConstructor
public class AuthorController {
    final private AuthorService authorService;

    @PostMapping
    public Author post(@Valid Author input) {
        return authorService.insert(input);
    }

    @DeleteMapping("{id}")
    public Author delete(@PathVariable long id) {
        return ControllerUtils.deleteIfExists("author", id, authorService::get, authorService::delete);
    }

    @PutMapping("{id}")
    public Author put(@PathVariable long id, @RequestBody @Valid Author input) {
        return authorService.update(id, input);
    }

    @GetMapping("{id}")
    public Author get(@PathVariable long id) {
        return authorService.get(id);
    }

    @GetMapping
    public List<Author> list() {
        return authorService.list();
    }

    @GetMapping(params = "size")
    public Page<Author> page(AuthorPageQuery query) {
        return authorService.page(query);
    }
}
