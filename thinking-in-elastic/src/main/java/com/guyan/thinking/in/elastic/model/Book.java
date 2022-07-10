package com.guyan.thinking.in.elastic.model;

/**
 * @Author: GuYan
 * @Time: 2022/7/10 13:43
 * @Description: 在ES之中存储一本书的数据
 **/
public class Book {
    private Long id;
    private String name;
    private String authorName;

    public Book() {
    }

    public Book(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", authorName='" + authorName + '\'' + '}';
    }
}
