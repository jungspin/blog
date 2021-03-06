package com.cos.blog.service.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.ModValid;
import com.cos.blog.util.Script;


public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // void 여도 return 가능
		// 1. 유효성 검사 -> postman 으로 하면 리콰이어 안먹음
		// ?username=ssar, ?username=, ?
//		if (request.getParameter("username")==null || request.getParameter("username").equals("")) {
//			return;
//		}else if (request.getParameter("password")==null || request.getParameter("password").equals("")) {
//			return;
//		}else if (request.getParameter("email")==null || request.getParameter("email").equals("")) {
//			return;
//		}else if (request.getParameter("address")==null || request.getParameter("address").equals("")) {
//			return;
//		}
		
		ModValid modValid = new ModValid();
		List<String> keys = Arrays.asList("username","password","email","address");
		
		if (modValid.mVaild(keys, request, response) != 1) {
			System.out.println("실패");
			return;
		}
		
		// 2. http body 데이터 변수로 받아야 됨
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String adderss = request.getParameter("address");
		User user = new User(null, username, password, email, adderss, null);
		
		// 3. DAO 연결해서 save() 하기
		// 4. result 받기
		UserDAO userDAO = UserDAO.getInstance(); // 이미 떠있는 객체를 가져오는 것
		int result = userDAO.save(user);
		
		
		// 5. 1일때, 1아닐때를 분기해서  1-> 로그인페이지(sendR) / !1-> joinForm페이지로 보내기
		if (result == 1) {
			//System.out.println("회원가입 성공, DB를 확인하세요.");
			// content-Type : text/html; charset=utf-8
			response.sendRedirect("views/user/loginForm.jsp"); // !!파일을 리턴!!
		}else {
			//System.out.println("회원가입 실패, 콘솔에 오류를 확인하세요.");
			Script.back("회원가입실패", response);
		}
		
	}
	
}
