package poly.edu.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import poly.edu.entity.RoleEnum;
import poly.edu.entity.Users;

@Component
public class AdminInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler)
			throws Exception {
		
		Object object = request.getSession().getAttribute("userLogged");
		
		Users users = (Users) object;
		System.out.println(users.getName());
		if(users == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
			}
		if(users.getRole() != RoleEnum.ADMIN) {
			response.setStatus(403);
			response.sendRedirect(request.getContextPath() + "/403");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
