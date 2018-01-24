package com.board.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerAction extends HttpServlet {
	
	private Map commandMap = new HashMap(); // ��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����
	
	public void init(ServletConfig config) throws ServletException {
		// Common properties
		loadProperties("com/board/properties/Command");
				
	}
	// properties ����
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);//������ ���������� rb�� ����.
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		while(actionEnumHome.hasMoreElements())
		{
			String command = actionEnumHome.nextElement();;
			String className = rbHome.getString(command);
			try {
				Class commandClass = Class.forName(className); // �ش� ���ڿ��� Ŭ������ �����
				Object commandInstance = commandClass.newInstance(); // �ش� Ŭ������ ��ü�� ����
				commandMap.put( command, commandInstance); // Map ��ü�� commandMap�� ��ü ����
			} catch(ClassNotFoundException e) {
				continue; // error
				//throw new ServletException(e);
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}				
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);		//get��İ� post����� ��� requestPro�� ó��
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	// ������� ��û�� �м��ؼ� �ش� �۾��� ó��
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		try {
			String command = request.getRequestURI();
			if ( command.indexOf(request.getContextPath()) == 0 ) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction)commandMap.get(command);
			if ( com == null ) {
				System.out.println("not found : " + command);
				return;
			}
			view = com.requestPro(request, response);
			if ( view == null ) {
				return; 
			}
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		
		if ( view == null ) 
			return;

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
