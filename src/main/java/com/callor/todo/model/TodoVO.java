package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
	
	private long seq;

	private String username;
	
	private String s_date;
	private String s_time;
	
	private String e_date;
	private String e_time;
	
	private String content;

	private boolean comp;
}
