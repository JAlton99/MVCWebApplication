package com.example.mvcwebapplication.servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import com.example.mvcwebapplication.dao.BookDAO;
import com.example.mvcwebapplication.model.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "bookServlet", value = "/books")
public class BookServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = bookDAO.getAllBooks();

        request.setAttribute("books", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("bookList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}