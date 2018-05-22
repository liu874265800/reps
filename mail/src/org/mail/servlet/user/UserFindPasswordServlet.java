package org.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mail.common.ResponseBody;
import org.mail.service.user.UsersService;
import org.mail.util.StringUtil;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 用于找回密码
 */
@WebServlet("/home/findPasswordServlet")
public class UserFindPasswordServlet extends HttpServlet {
	
	private UsersService usersService = new UsersService();
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		ResponseBody responseBody = new ResponseBody();
		if(StringUtil.isEmpty(email)){
			responseBody.setStatus(-1);
			responseBody.setMessage("邮箱不能为空.");
			response.getWriter().write(responseBody.toJson());
			return;
		}
		
		boolean state = usersService.findPassword(email);
		if(state){
			responseBody.setMessage("新密码已发送到你邮箱.");
		}else{
			responseBody.setStatus(-1);
			responseBody.setMessage("您输入有邮箱不存在.");
		}
		response.getWriter().write(responseBody.toJson());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
