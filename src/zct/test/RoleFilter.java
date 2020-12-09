package zct.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zct.user.User;

/**
 * Servlet Filter implementation class RoleFilter
 */

public class RoleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RoleFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//System.out.println("À¹½ØÆ÷¿ªÊ¼£¡" + req.getRequestURL());
		//System.out.println("À¹½ØÆ÷¿ªÊ¼£¡" + req.getRequestURI());
		System.out.println("À¹½ØÆ÷¿ªÊ¼£¡" + req.getContextPath() + "--" + req.getRequestURI());
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null) {
			chain.doFilter(request, response);
		}
		else {
			request.setAttribute("infor", "ÇëÏÈµÇÂ¼");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		System.out.println("À¹½ØÆ÷½áÊø£¡");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
