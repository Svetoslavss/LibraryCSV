package com.traiding.Client.controllers;

import com.traiding.Client.models.Book;
import com.traiding.Client.models.Magazines;
import com.traiding.Client.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService service;

    @GetMapping("/books")
    public String viewBooks(Model model)  {
        model.addAttribute("book", new Book());
        model.addAttribute("books", service.getBooks());
        return "books";
    }
    @PostMapping("/books")
    public String addBook(@ModelAttribute Book book){
        service.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/magazines")
    public String viewMagazines(Model model){
        model.addAttribute("magazine", new Magazines());
        model.addAttribute("magazines", service.getMagazines());
        return "magazines";
    }

    @PostMapping("/magazines")
    public String addMagazine(@ModelAttribute Magazines magazines){
        service.addMagazine(magazines);
        return "redirect:/magazines";
    }


    @PostMapping("/books/delete")
    public String deleteBook(Model model){
       try {
           service.deleteAllBooks();
           model.addAttribute("All books are deleted");
       } catch (Exception e){
           model.addAttribute("error", "Error occurred during deletion.");
       }
       model.addAttribute("books", service.getBooks());
       return "redirect:/books";
    }



    @PostMapping("magazines/delete")
    public String deleteMagazine(Model model){
       try {
           service.deleteAllMagazines();
           model.addAttribute("All magazines are deleted");
       } catch (Exception e){
           model.addAttribute("error", "Error occurred during deletion.");
       }
       model.addAttribute("magazines", service.getMagazines());
       return "redirect:/magazines";
    }

}
