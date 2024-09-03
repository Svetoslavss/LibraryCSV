package com.traiding.Client.services;

import com.traiding.Client.models.Book;
import com.traiding.Client.models.Magazines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class LibraryService {


    @Autowired
    private CsvService service;


    public List<Book> getBooks()  {
    return service.readBooks();
    }

   public List<Magazines> getMagazines(){
    return service.readMagazines();
    }

    public void addBook(Book book){
        service.saveBook(book);
    }
    public void addMagazine(Magazines magazines){
       service.saveMagazine(magazines);
    }

    public void deleteAllBooks(){
       service.clearAllBooks();
    }

    public void deleteAllMagazines(){
      service.clearAllMagazines();
    }


}
