package org.mvcspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHello{
	@RequestMapping(value = "/")
	public String showHelloView(){
		return "hello-view";
	}
}
