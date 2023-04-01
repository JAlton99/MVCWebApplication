package com.example.mvcwebapplication.servlets;

import com.example.mvcwebapplication.dao.BookDAO;
import com.example.mvcwebapplication.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "InsertBookServlet", value = "/insertBook")
public class InsertBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("insertBook.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve form data from request
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String date = request.getParameter("date");
        String genres = request.getParameter("genres");
        String characters = request.getParameter("characters");
        String synopsis = request.getParameter("synopsis");

        // Create new book object
        Book book = new Book(title, author, date, genres, characters, synopsis);

        // Update book in database using the BookDAO class
        BookDAO bookDAO = new BookDAO();
        bookDAO.insertBook(book);

        // Redirect to success page
        response.sendRedirect(request.getContextPath() + "/books");
    }
}

