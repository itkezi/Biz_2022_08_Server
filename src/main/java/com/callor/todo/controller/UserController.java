package com.callor.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return null;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {

		userService.insert(userVO);

		return "redirect:/";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(String error, Model model) {
		
		model.addAttribute("error",error);
		model.addAttribute("LAYOUT","LOGIN");
		
		return "/user/login";
	}
	

}
