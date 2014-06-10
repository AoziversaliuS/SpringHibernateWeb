package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web.pojo.Player;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/register.do")
	public String regist(Player p){
		System.out.println("UserController.regist()");
		return "success";
	}

}
