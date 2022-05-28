package com.example.bookstore.model;

public class Book {

    private String Name,Author,Description,Image;
    private int Price;

    public Book(){}

    public Book(String name, String author, String description, String image, int price) {
        Name = name;
        Author = author;
        Description = description;
        Image = image;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }


}
