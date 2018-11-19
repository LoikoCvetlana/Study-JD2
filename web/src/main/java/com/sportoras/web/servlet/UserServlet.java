package com.sportoras.web.servlet;

import com.sportoras.database.entity.User;
import com.sportoras.service.service.UserService;
import com.sportoras.web.utilit.ContextHolder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private UserService userService = ContextHolder.getContext().getBean("userService", UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.findById(1L);
        req.setAttribute("user", user);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
