package com.example.servletproject.samples;

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
