package com.cos.blog.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 유효성 검사
		
		// 2. http body 데이터 변수로 받아야 됨
		
		// 3. DAO 연결해서 save() 하기
		
		// 4. result 받기
		
		// 5. 1일때, 1아닐때를 분기해서  1-> 로그인페이지(sendR) / !1-> joinForm페이지로 보내기
		
	}
	
}
