package com.sportoras.web.servlet;

import com.sportoras.database.entity.Product;
import com.sportoras.service.service.ProductService;
import com.sportoras.web.utilit.ContextHolder;
import com.sportoras.web.utilit.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private ProductService productService = ContextHolder.getContext().getBean("productService", ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("products"))
                .forward(req, resp);
    }
}