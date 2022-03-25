package com.example.controller;

import com.example.dto.BookDto;
import com.example.entity.Library;
import com.example.entity.Book;
import com.example.service.AllService;
//import com.example.service.BiblioteciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class IndexController {

 @Autowired
 AllService service;
/* @Autowired
 BiblioteciService service;*/
//CartiService service = new CartiService();


    @GetMapping(value="/index")
    public String getIndex(Model model){

        return "index";
    }

    @GetMapping(value="/book")
    public String getBook(Model model) {

        List<BookDto> bookDtoList = service.getBookList();
        model.addAttribute("bookList", service.getBookDtoList);
       // model.addAttribute("ListaCarti", cartiList);

        return "book";
    }

    @GetMapping(value="/library")
    public String getLibrary(Model model) {

        /*List<Biblioteci> biblioteciList = List.of(
                new Biblioteci("Biblioteca Liceului de Arte Regina Maria ","Alba Iulia" ),
                new Biblioteci("Biblioteca Municipală „Ștefan Luchian” ","Moinești" ),
                new Biblioteci("Biblioteca Universității Transilvania","Brasov" ),
                new Biblioteci("Biblioteca Institutului de Matematică „Simion Stoilow” al Academiei Române","Bucuresti" )

        );*/

        model.addAttribute("libraryList",service.getLibraryList());
        model.addAttribute("bookList", service.getBookList());


        return "library";

    }

    @GetMapping(value="/createLibrary")
    public String createLibrary(Model model){
        Library library = new Library();
        model.addAttribute("library", library);
        return "formPageLibrary";
    }

    @GetMapping(value="/createBook")
    public String createBook(Model model){
        BookDto bookDto = new BookDto();
        model.addAttribute("book", bookDto);
        return "formPage";
    }

    @PostMapping(value="/submitBook")
    public String submitBook(@ModelAttribute BookDto bookDto){

        service.saveBook(bookDto);

      //  repository.save(carti);
        return "redirect:/book";


    }
    @PostMapping(value="/submitLibrary")
    public String submitLibrary(@ModelAttribute Library library){
        System.out.println(library.getNameLibrary());
        System.out.println(library.getLocation());
        service.saveLibrary(library);

        //  repository.save(carti);
        return "redirect:/index";


    }

    @PostMapping  (value="/deleteBook")
    public String deleteBook(@RequestParam("bookId")int id){
        service.deleteBook(id);
        return "redirect:/book";
    }
    @PostMapping  (value="/editBook")
    public String editBook(@RequestParam("bookId")int id, Model model){
        BookDto bookDto = service.findBookById(id);
        model.addAttribute("book", bookDto);
        return "formPage";
    }
}

