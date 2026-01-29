package org.example;


public class FamousSaying {
    private final int id;
    private  String content;
    private  String author;


    public FamousSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void update(String content, String author) {
        this.content = content;
        this.author = author;
    }
}
