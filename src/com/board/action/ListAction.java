package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {

		int page = 0;				 // �⺻ ��������ȣ�� 0���� �����ϰ�
		if(request.getParameter("page") != null){				 // �Ѿ�� �Ķ���Ͱ� �ִٸ� 	
			page = Integer.parseInt(request.getParameter("page"));
		}			  // �ش� �Ķ���͸� int������ ĳ������ ������ �����մϴ�.
			ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(page);	
																							// �׸��� ����� dao �޼��忡 �־��ݴϴ�.
			request.setAttribute("articleList", articleList);	// ���õ� ����Ʈ�� �信 �������մϴ�.
			request.setAttribute("page", page);	// ��������ȣ�� �信�� �������� ǥ���մϴ�.

		return "list.jsp";
		}

}
