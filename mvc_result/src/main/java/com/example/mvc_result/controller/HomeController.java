package com.example.mvc_result.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/setEmployee")
	public String setEmployee(){
		return "setEmployee";
	}

	@RequestMapping(value = "/getEmployee")
	public String getEmployee(HttpServletRequest request, Model model)
		throws IOException{
		String name = request.getParameter("emplName");
		name = "sir " + name;
		model.addAttribute("atName", name);
		return "getEmployee";
	}
}