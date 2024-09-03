package com.traiding.Client.services;

import com.traiding.Client.models.Book;
import com.traiding.Client.models.Magazines;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    private static final String BOOKS_CSV = "src/main/resources/books.csv";
    private static final String MAGAZINES_CSV = "src/main/resources/magazines.csv";

    public List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_CSV))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String author = data[0];
                    String title = data[1];
                    String content = data[2];
                    String isbn = data[3];
                    Book book = new Book(author, title, content, isbn);
                    books.add(book);
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public void saveBook(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_CSV, true))) {
            writer.write(STR."\{book.getAuthor()},\{book.getTitle()},\{book.getContent()},\{book.getIsbn()}");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Magazines> readMagazines() {
        List<Magazines> magazines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MAGAZINES_CSV))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                String title = data[0];
                String publisher = data[1];
                int year = Integer.parseInt(data[2]);
                String issn = data[3];
                Magazines magazine = new Magazines(title, year, publisher, issn);
                magazines.add(magazine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return magazines;
    }

    public void saveMagazine(Magazines magazines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MAGAZINES_CSV, true))){
            writer.write(STR."\{magazines.getTitle()},\{magazines.getPublisher()},\{magazines.getYear()},\{magazines.getIssn()}");
            writer.newLine();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void clearAllBooks(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_CSV))){
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void clearAllMagazines(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MAGAZINES_CSV))){
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}
