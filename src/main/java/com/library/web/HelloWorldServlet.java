package com.library.web;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.io.PrintWriter;

@CrossOrigin(origins = "*")
@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @CrossOrigin
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.write("<html><head></head><body>Hello!</body></html>");
        writer.flush();

    }

}
