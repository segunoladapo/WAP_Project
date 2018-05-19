package security;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 986296 on 5/19/2018.
 */

@WebFilter(urlPatterns = {"/todoList","/welcome"})
public class AuthenticationFilter implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) req;
        if(servletRequest.getSession() == null || servletRequest.getSession().getAttribute("userName") == null){
            req.setAttribute("msg","Please Login to continue");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }else {
            chain.doFilter(req, resp);//sends request to next resource
        }

    }
    public void destroy() {}
}
