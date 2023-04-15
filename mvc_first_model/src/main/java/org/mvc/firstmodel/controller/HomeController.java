package org.mvc.firstmodel.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mvc.firstmodel.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/setEmplView", method = RequestMethod.GET)
	public String setMyEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "setEmplView";
	}

	@RequestMapping(value = "/getEmplView", method = RequestMethod.GET)
	public String getMyEmployee(@Valid @ModelAttribute("employee") Employee e, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "setEmplView";
		} else {
			return "getEmplView";
		}
	}
}
