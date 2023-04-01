package com.example.mvcwebapplication.servlets;

import com.example.mvcwebapplication.dao.BookDAO;
import com.example.mvcwebapplication.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateBookServlet", value = "/updateBook")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.getBookByID(id);

        request.setAttribute("book", book);

        RequestDispatcher dispatcher = request.getRequestDispatcher("updateBook.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String date = request.getParameter("date");
        String genres = request.getParameter("genres");
        String characters = request.getParameter("characters");
        String synopsis = request.getParameter("synopsis");

        Book updatedBook = new Book(id, title, author, date, genres, characters, synopsis);
        updatedBook.setId(id);

        BookDAO bookDAO = new BookDAO();
        bookDAO.updateBook(updatedBook);

        response.sendRedirect("books");

    }
}
