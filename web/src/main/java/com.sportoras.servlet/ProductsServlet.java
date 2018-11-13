package com.sportoras.servlet;

import com.sportoras.entity.Product;
import com.sportoras.service.ProductService;
import com.sportoras.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductService.getInstance().findAll();
        req.setAttribute("products", products);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("products"))
                .forward(req, resp);
    }
}