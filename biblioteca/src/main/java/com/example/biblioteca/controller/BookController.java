package com.example.biblioteca.controller;
//controller concentra os requests para pegar os dados dos livros e também adicionar novos dados no banco de dados!

import com.example.biblioteca.book.Book;
import com.example.biblioteca.book.BookRepository;
import com.example.biblioteca.book.BookRequestDTO;
import com.example.biblioteca.book.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//dizendo para o spring que a classe é um controller
@RestController
//informando ao spring qual o endpoint que ele controla
@RequestMapping("book")
public class BookController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveBook(@RequestBody BookRequestDTO data){
        Book BookData = new Book(data);
        repository.save(BookData);
        return;
    }

    @Autowired
    private BookRepository repository;

    /*endpoint get retornar todos os books do banco de dados
    quando bater nesse endpoint book com o metodo get será executado esse metodo*/
    @GetMapping
    public List<BookResponseDTO> getAll(){
        List<BookResponseDTO> bookList = repository.findAll().stream().map(BookResponseDTO::new).toList();
        return bookList;
    }
}
