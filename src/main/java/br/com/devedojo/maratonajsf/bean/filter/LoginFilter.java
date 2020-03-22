package br.com.devedojo.maratonajsf.bean.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.devedojo.maratonajsf.bean.login.LoginBean;

public class LoginFilter implements Filter {
	
	@Inject
	private LoginBean loginBean;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getRequestURI().toString();
		System.out.println(url);
		if (url.contains("/restricted") && loginBean.getEstudante() == null) {
			res.sendRedirect(req.getServletContext().getContextPath()+"/login.xhtml");
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
