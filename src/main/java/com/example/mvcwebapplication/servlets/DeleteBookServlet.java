package com.example.mvcwebapplication.servlets;

import com.example.mvcwebapplication.dao.BookDAO;
import com.example.mvcwebapplication.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteBookServlet", value = "/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        BookDAO bookDAO = new BookDAO();
        bookDAO.deleteBook(bookId);

        // Fetch the updated list of books
        List<Book> books = bookDAO.getAllBooks();

        // Set the updated list of books as a request attribute
        request.setAttribute("books", books);

        // Forward the request to bookList.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookList.jsp");
        dispatcher.forward(request, response);
    }
}

