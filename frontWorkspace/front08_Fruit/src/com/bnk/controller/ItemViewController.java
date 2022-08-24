package com.bnk.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bnk.model.Item;
import com.bnk.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int itemnumber = Integer.parseInt(request.getParameter("itemnumber"));
		
		Item item = ItemDao.getInstance().getItem(itemnumber);
		ItemDao.getInstance().updateRecordCount(itemnumber);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}
