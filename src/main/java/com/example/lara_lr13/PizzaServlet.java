package com.example.lara_lr13;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "pizzaServlet", value = "/pizzaServet")
public class PizzaServlet extends HttpServlet {

    Connection conn;
    Statement statement;
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaDb","root","");
            statement = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = "SELECT * FROM Pizza";
        try {
            ResultSet res = statement.executeQuery(query);
            List<Pizza> pizzas = new ArrayList<>();
            while (res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                double price = res.getDouble("price");
                Pizza pizza = new Pizza(id,name,price);
                pizzas.add(pizza);
            }
            request.setAttribute("pizzas",pizzas);
            request.getRequestDispatcher("/showPizza.jsp").forward(request,response);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}