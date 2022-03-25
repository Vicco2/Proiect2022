package com.example.service;

import com.example.dto.BookDto;
import com.example.entity.Book;
import com.example.entity.Library;
import com.example.repository.BookRepository;
import com.example.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AllService {

    @Autowired
    BookRepository bookRepository;

    List<Book> bookList = new ArrayList<>();

    public List<BookDto> getBookList() {

        return bookRepository.findAll().stream()
                .map(e -> {
                    BookDto bookDto = new BookDto();
                    bookDto.setId(e.getId());
                    bookDto.setName(e.getName());
                    bookDto.setYear(e.getYear());
                    bookDto.setWriter(e.getWriter());
                    bookDto.setPrice(e.getPrice());
                    return bookDto;
                })
                .collect(Collectors.toList());
    }

    @Autowired
    LibraryRepository LibraryRepository;

    List<Library> libraryList = new ArrayList<>();

    public List<Library> getLibraryList() {
        return LibraryRepository.findAll();
    }


    public void saveBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setYear(bookDto.getYear());
        book.setWriter(bookDto.getWriter());
        book.setPrice(bookDto.getPrice());
        bookRepository.save(book);
    }
    public void saveLibrary(Library library) {
        LibraryRepository.save(library);}

    public void deleteBook(int id){
    bookRepository.deleteById(id);
    }
    public BookDto findBookById(int id){
        Book book = bookRepository.findById(id).get();
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setYear(book.getYear());
        bookDto.setWriter(book.getWriter());
        bookDto.setPrice(book.getPrice());
        bookRepository.save(book);
        return bookDto ;

    }
}


