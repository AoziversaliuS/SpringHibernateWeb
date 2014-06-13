package web.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public String regist(Player p,HttpServletRequest request){
		System.out.println("UserController.regist()");
		pdi.add(p);
		request.setAttribute("message", "UserController.regist()");
		return "success";
	}
	
	
	@RequestMapping("/get.do")
	public String get(int id,HttpServletRequest request){
		System.out.println("UserController.get()");
		request.setAttribute("message", "UserController.get()");
		
		Player p = (Player)pdi.getPlayer(id);
		
		System.out.println("name = "+p.getName());
		
		return "success";
	}
	
	

}
