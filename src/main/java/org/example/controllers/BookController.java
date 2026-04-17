package org.example.controllers;

import org.example.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //TODO http://localhost:8080/get_registration_numbers_all_books
    @GetMapping("/get_registration_numbers_all_books")
    public String getRegistrationNumberAllBooks() {
        return bookService.returnListRegistrationNumbersBooks();
    }

    //TODO http://localhost:8080/save_registration_number_book
    //TODO Написать метод по сохранению названия книги в списке(сервисе)
    @PostMapping("/save_registration_number_book")
    public ResponseEntity.BodyBuilder saveRegistrationNumberBook(@RequestBody Map<String, Integer> map) {
        try {
            bookService.save(map);
            return ResponseEntity.status(HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    //TODO Задание: добиться удаления книги по её рег-му номеру
    //TODO http://localhost:8080/deleteBook/111
    @DeleteMapping("/deleteBook/{registration_number}")
    public ResponseEntity.BodyBuilder deleteBook(@RequestParam Map<String, Integer> mapRegistration_number) {
        try {
            bookService.deleteBook(mapRegistration_number);
            return ResponseEntity.status(HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}
