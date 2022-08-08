package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authenticationProvider")
public class AuthenticationProviderImpl  implements AuthenticationProvider{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		log.debug("사용자  {}, {}",username,password);
		
		UserVO userVO = userDao.findById(username);
		
		
		if(userVO == null) {
			throw new UsernameNotFoundException(username + "은(는) 없는 아이디입니다");
		}
		
		log.debug("사용자 있음 {}",userVO);
		if(userVO.getPassword().equals(password) == false) {
			throw new BadCredentialsException("비밀번호를 틀렸습니다");
		}
		log.debug("비번 OK");

		List<AuthorityVO> authList = userDao.select_auths(username);
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		for(AuthorityVO vo : authList) {
			grantList.add(new SimpleGrantedAuthority(vo.getAuthority()));
		}

		userVO.setAuthorities(grantList);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userVO, null, grantList);
		
		
		log.info(userVO.toString());
		
		return token;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
