package com.sportoras.servlet;

import com.sportoras.dto.ProductDtoFilter;
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

@WebServlet("/product-filter")
public class ProductFilterServlet extends HttpServlet {

    private ProductDtoFilter productDto;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> producta = ProductService.getInstance().filtrProduct(productDto.getProductName(), productDto.getValue(), productDto.getLimit(), productDto.getOffset());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("products"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDtoFilter productDto = ProductDtoFilter.builder()
                .productName(req.getParameter("name"))
                .value(Double.valueOf(req.getParameter("value")))
                .limit(Integer.valueOf(req.getParameter("limit")))
                .offset(Integer.valueOf(req.getParameter("offset")))
                .build();

        resp.sendRedirect("/product-filtered");
    }
}
