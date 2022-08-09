package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, Long> {

	public List<TodoVO> findByUserName(String username);
	
	public void create_todo_table();
	
	public int content_update(TodoVO todoVO);
	
	public int comp_update(TodoVO todoVO);
	
}
