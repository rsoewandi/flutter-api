package com.flutter.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.flutter.api.model.Mstaff;
import com.flutter.api.repository.MstaffRepository;
import com.flutter.api.response.TokenUserResponse;
import com.flutter.api.service.RestTemplateService;
import com.flutter.api.utils.UtilsRole;



@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	RestTemplateService restTemplate;
	
	@Autowired
	MstaffRepository mstaffRepo;
	
	@Autowired
	private CustomPasswordEncoder passwordEncoder;
	
	private String[] roles;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		Mstaff mstaff = mstaffRepo.findByStaffid(username);
		if (passwordEncoder.matches(password,mstaff.getPassword())) {

			TokenUserResponse tokenUserResponse = new TokenUserResponse();
			List<String> listString = new ArrayList<>();
			listString.add(UtilsRole.ROLE_USER.getText());
			roles = listString.toArray(new String[listString.size()]);
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils.createAuthorityList(roles);
				
			return new UsernamePasswordAuthenticationToken(tokenUserResponse, null, grantedAuthorities);
		}else {
			throw new UsernameNotFoundException("Password wrong!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

//	private User buildUserForAuthentication(UserInformation user, List<GrantedAuthority> authorities) {
//		String username = user.getUsername();
//		String password = user.getPassword();
//
//		UserResponse userResponse = new UserResponse(username, password, authorities);
//
//		// userResponse.setPrivilege(privilegeRepo.findByCorporateCorporateId(corporate.getCorporateId()));
//
//		return userResponse;
//	}

}
