package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service("todoServiceV1")
public class TodoServiceImplV1 implements TodoService {
	
	@Autowired
	private TodoDao todoDao;

	@Override
	public List<TodoVO> findByUserName(String username) {
		
		return todoDao.findByUserName(username);
	}

	@Bean
	@Override
	public void create_todo_table() {
		todoDao.create_todo_table();
	}

	@Override
	public int content_update(TodoVO todoVO) {
		return todoDao.content_update(todoVO);
	}

	@Override
	public int comp_update(TodoVO todoVO) {
		return todoDao.comp_update(todoVO);
	}

	@Override
	public List<TodoVO> selectAll() {
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(Long id) {
		return todoDao.findById(id);
	}

	@Override
	public int insert(TodoVO vo) {
		return todoDao.insert(vo);
	}

	@Override
	public int update(TodoVO vo) {
		return 0;
	}

	@Override
	public int delete(Long id) {
		return todoDao.delete(id);
	}



}
