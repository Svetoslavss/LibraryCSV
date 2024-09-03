package com.traiding.Client.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Magazines {
    private String title;
    private String publisher;
    private int year;
    private String issn;

    public Magazines(String title, int year, String publisher, String issn) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.issn = issn;
    }

    public Magazines() {}

}
