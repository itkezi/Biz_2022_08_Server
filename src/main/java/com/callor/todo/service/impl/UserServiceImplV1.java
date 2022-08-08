package com.callor.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.UserService;

@Service("userServiceV1")
public class UserServiceImplV1 implements UserService{
	
	// 새로 작성1-----------
	
	@Autowired
	private UserDao userDao;
	
	@Bean
	public void create_table() {
		userDao.create_user_table();
		userDao.create_auth_table();
	}
	
	// --------------------1
	
	
	@Override
	public void create_user_table() {
		
	}

	@Override
	public void create_auth_table() {
		
	}

	@Override
	public List<AuthorityVO> select_auths(String username) {
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		return null;
	}

	@Override
	public UserVO findById(String id) {
		return null;
	}

	@Override
	public int insert(UserVO vo) {
		
		List<UserVO> userList = userDao.selectAll();
		List<AuthorityVO> authList = new ArrayList<>();
		
		if(userList == null || userList.size() < 1) {
			
			//  최초로 회원가입을 하면 Enabled를 true / ADMIN, USER 권한을 부여한다
			vo.setEnabled(true);
			authList.add(AuthorityVO.builder().username(vo.getUsername()).authority("ROLE_ADMIN").build());
			authList.add(AuthorityVO.builder().username(vo.getUsername()).authority("ROLE_USER").build());
		} else {
			authList.add(AuthorityVO.builder().username(vo.getUsername()).authority("ROLE_USER").build());
		};
		
		userDao.role_insert(authList);
		
		return userDao.insert(vo);		
	}

	@Override
	public int update(UserVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int role_insert(List<AuthorityVO> auths) {
		return 0;
	}

}
