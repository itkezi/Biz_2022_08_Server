package com.callor.todo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String todo(Model model, Principal principal) {
		
		
		List<TodoVO> tdList = todoService.findByUserName(principal.getName());
		
		model.addAttribute("TODO",tdList);
		
		return "/todo/home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@PathVariable("seq") Long seq){
		
	return "todo/insert";
	}

}
