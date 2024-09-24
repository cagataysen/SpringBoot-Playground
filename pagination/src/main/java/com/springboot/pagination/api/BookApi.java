package com.springboot.pagination.api;

import com.springboot.pagination.model.Book;
import com.springboot.pagination.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookApi {

    private final BookRepository bookRepository;


    /*parameters: pageSize and page ==> which page, how big should I bring (kacinci sayfayi (page) kac sayfa (pageSize) getireyim)*/
    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize, @RequestParam Integer page){

        Pageable pageable = PageRequest.of(page, pageSize);
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        // totalElements count query
        return bookRepository.findAll(pageable);
    }

    //Performance better with Slice -- twitter timeline for ex.
    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

}
