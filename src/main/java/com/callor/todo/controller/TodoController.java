package com.callor.todo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@Controller
@RequestMapping(value="/todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	Date curDate = new Date(System.currentTimeMillis());
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
	
	String today = dateFormat.format(curDate);
	String time = timeFormat.format(curDate);
	
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String todo(Model model, Principal principal) {
		
		
		List<TodoVO> tdList = todoService.findByUserName(principal.getName());
		
		model.addAttribute("TODO",tdList);
		
		return "/todo/home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Principal principal, Model model){

		TodoVO tVO = TodoVO.builder().username(principal.getName()).s_date(today).s_time(time).comp(false).build();
		
		model.addAttribute("TODO",tVO);
		
	return "todo/insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(TodoVO todoVO) {
	
		todoService.insert(todoVO);
		
		return "redirect:/todo/";
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq") long seq,Model model) {

		TodoVO tVO = todoService.findById(seq);	

		model.addAttribute("TODO",tVO);
		
		return "/todo/insert";
	}
	
	@RequestMapping(value="/update/{seq}" , method=RequestMethod.POST)
	public String update(@PathVariable("seq") long seq,TodoVO todoVO) {
		
		todoService.content_update(todoVO);
		
		return "redirect:/todo/";
	}
	
	@RequestMapping(value="/comp/{seq}")
	public String comp(@PathVariable("seq") long seq) {
		
		TodoVO tVO = todoService.findById(seq);

		tVO.setE_date(today);
		tVO.setE_time(time);
		tVO.setComp(true);
		
		todoService.comp_update(tVO);
		
		return "redirect:/todo/";
	}
	
	@RequestMapping(value="/delete/{seq}")
	public String delete(@PathVariable("seq") long seq) {
		
		todoService.delete(seq);
		
		return "redirect:/todo/";
	}
	
	
	
	
	

}
