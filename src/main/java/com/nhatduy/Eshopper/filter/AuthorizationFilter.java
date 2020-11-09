package com.nhatduy.Eshopper.filter;

import com.nhatduy.Eshopper.common.constants.SystemContants;
import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.utils.SessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();
        if (url.startsWith("/admin-home")) {
            UserDTO userDTO = (UserDTO) SessionUtils.getInstance().getValue(request, "USERMODEL");
            if (userDTO != null) {
                if (userDTO.getRoleName().contains(SystemContants.ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (userDTO.getRoleName().contains(SystemContants.USER)) {
                    response.sendRedirect(request.getContextPath() + "/user/login?message=not_permission&alert=danger");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/user/login?message=not_login&alert=danger");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
