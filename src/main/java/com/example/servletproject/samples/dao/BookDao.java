package com.example.servletproject.samples.dao;

import com.example.servletproject.samples.Book;
import com.example.servletproject.samples.Store;

import java.util.List;

public class BookDao {
    private Store bookStore;

    public BookDao() {
        this.bookStore = new Store();
    }

    public boolean createBook(Book book) {
        if (book != null) {
            this.bookStore.insertBook(book);
            return true;
        } else {
            return false;
        }
    }

    public List getList() {
        return this.bookStore.getBookList();
    }
}
