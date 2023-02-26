package com.example.servletproject.contoller;

import com.example.servletproject.dao.BookDao;
import com.example.servletproject.entity.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/bookcontoller")
public class BookContoller extends HttpServlet {

    BookDao bookDao;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/bookindex.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        String bookAuthor = req.getParameter("bookAuthor");
        String bookDescription = req.getParameter("bookDescription");

        Book book = new Book(bookName, bookAuthor, bookDescription);
        bookDao.createBook(book);

        List<Book> books = bookDao.getList();
        books.forEach(i -> System.out.println(i));

        req.setAttribute("books", books);
        req.getRequestDispatcher("/WEB-INF/books.jsp").forward(req, resp);
    }
}
