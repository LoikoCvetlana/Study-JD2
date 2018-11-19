package com.sportoras.web.servlet;

import com.sportoras.database.entity.Product;
import com.sportoras.service.dto.ProductDtoFilter;
import com.sportoras.service.service.ProductService;
import com.sportoras.web.utilit.ContextHolder;
import com.sportoras.web.utilit.JspPathUtil;
import org.springframework.data.domain.PageRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product-filter")
public class ProductFilterServlet extends HttpServlet {

    private ProductService productService = ContextHolder.getContext().getBean("productService", ProductService.class);
    private ProductDtoFilter productDto;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> producta = productService.filterProduct(productDto.getProductName(), productDto.getMinValue(), productDto.getMaxValue(), productDto.getPageable());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("products"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDtoFilter productDto = ProductDtoFilter.builder()
                .productName(req.getParameter("name"))
                .minValue(Double.valueOf(req.getParameter("minValue")))
                .maxValue(Double.valueOf(req.getParameter("maxValue")))
                .pageable(PageRequest.of(0, 1))
                .build();

        resp.sendRedirect("/product-filtered");
    }
}
