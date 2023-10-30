package com.example.lara_lr13;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "buyPizzaServlet", value = "/buyPizzaServlet")
public class BuyPizzaServlet extends HttpServlet {

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/showPizza.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int pizzaId = Integer.parseInt(request.getParameter("pizzaId"));
            String query = "SELECT * FROM Pizza WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, pizzaId);
            ResultSet res = preparedStatement.executeQuery();
            Pizza pizza = null;
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                double price = res.getDouble("price");
                pizza = new Pizza(id, name, price);
            }
            query = "SELECT * FROM Delivery";
            res = statement.executeQuery(query);
            List<Delivery> deliveries = new ArrayList<>();
            while (res.next()){
                int id = res.getInt("id");
                String streetName = res.getString("streetName");
                int houseNumber = res.getInt("houseNumber");
                Delivery delivery = new Delivery(id,streetName,houseNumber);
                deliveries.add(delivery);
            }
            request.setAttribute("deliveries",deliveries);
            request.setAttribute("pizza", pizza);
            request.getRequestDispatcher("/pizzaBuy.jsp").forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void destroy() {
    }
}