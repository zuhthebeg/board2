package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class CountAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int idx =Integer.parseInt( request.getParameter("idx"));		//�� �������κ��� �Ѿ�� idx���� �ް�
		
		Board article = BoardDao.getInstance().getArticle(idx);		// �Խñ� ��ü�� �����ɴϴ�.
		String regip = request.getRemoteAddr();	// ���� ��ȸ�� ��û�� ������� ip�� �ް�

		if(!regip.equals(article.getRegip())){			// �Խñ��� ip�� �������� ������
			int count = article.getCount();					// �Խñ��� ip�� �޾Ƽ� 
			article.setCount(++count);						// +1 ���ְ� �Խñۺ� �����մϴ�.
			BoardDao.getInstance().setArticleCount(article);	// ���� �� ���� �Ķ���ͷ� ������Ʈ�մϴ�.
		}
		request.setAttribute("url", "content.do?idx="+idx);

		return "redirect2.jsp";
		}
}
