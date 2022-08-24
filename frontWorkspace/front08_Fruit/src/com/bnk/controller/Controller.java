package com.bnk.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Template 기능...
public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException; 
}
