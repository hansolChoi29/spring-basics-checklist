package com.example.springbasicstraining.labs.step10_response_entity.controller;


import com.example.springbasicstraining.labs.step10_response_entity.dto.BookRequest;
import com.example.springbasicstraining.labs.step10_response_entity.dto.BookResponse;
import com.example.springbasicstraining.labs.step10_response_entity.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    // Create (201 Created)
    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest) {
        BookResponse bookResponse = bookService.create(bookRequest);
        return ResponseEntity.status(201).body(bookResponse);
    }
    // Read (200 or 404)
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> read(@PathVariable Long id) {
        return bookService.find(id)
                .map(ResponseEntity::ok)// 200 OK
                .orElse(ResponseEntity.notFound().build());//404NotFound
    }
    // Delete (204 or 404)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean removed = bookService.delete(id);
        if (!removed) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
