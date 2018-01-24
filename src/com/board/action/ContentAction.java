package com.board.action;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int idx =Integer.parseInt( request.getParameter("idx"));		//전 페이지로부터 넘어온 idx값을 받고
		
		Board article = BoardDao.getInstance().getArticle(idx);	
		
		request.setAttribute("article", article);

		return "content.jsp";
		}

}
