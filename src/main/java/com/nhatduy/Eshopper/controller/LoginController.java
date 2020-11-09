package com.nhatduy.Eshopper.controller;

import com.nhatduy.Eshopper.common.constants.SystemContants;
import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.service.UserService;
import com.nhatduy.Eshopper.utils.FormUtils;
import com.nhatduy.Eshopper.utils.SessionUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/user/login", "/logout"})
public class LoginController extends HttpServlet {

    @Inject
    private UserService userService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action != null && action.equals("/user/login")) {
            String message = request.getParameter("message");
            String alert = request.getParameter("alert");
            if (message != null && alert != null) {
                request.setAttribute("message", resourceBundle.getString(message));
                request.setAttribute("alert", alert);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/login/login.jsp");
            requestDispatcher.forward(request, response);
        } else if (action != null && action.equals("/logout")) {
            SessionUtils.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserDTO userDTO = FormUtils.populate(UserDTO.class, request);
            userDTO = userService.checkExistUser(userDTO.getUserName(), userDTO.getPassWord());
            if (userDTO != null) {
                SessionUtils.getInstance().putValue(request, "USERMODEL", userDTO);
                if (userDTO.getRoleName().contains(SystemContants.ADMIN)) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                } else if (userDTO.getRoleName().contains(SystemContants.USER)) {
                    response.sendRedirect(request.getContextPath() + "/home");
                }
            } else
                response.sendRedirect(request.getContextPath() + "/user/login?message=login_failed&alert=danger");
        }
    }
}
