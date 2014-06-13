package web.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dao.PlayerDaoImpl;
import web.pojo.Player;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private PlayerDaoImpl pdi;
	
	@RequestMapping("/register.do")
	public String regist(Player p){
		System.out.println("UserController.regist()");
		pdi.add(p);
		return "success";
	}

}
