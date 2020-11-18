package com.samyak.secureap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.models.LoginAccount;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	LoginAccountDao loginAccountDao;
	
	//public UserDetailsServiceImpl() {
	//	// TODO Auto-generated constructor stub
	//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginAccount loginAccount = loginAccountDao.findByUsername(Integer.parseInt(username));
		//User user = userDao.findByUsername(username);
        if (loginAccount == null) {
            throw new UsernameNotFoundException("Invalid username");
        }
        List<GrantedAuthority> grantList = new ArrayList<>();

        GrantedAuthority authority = new SimpleGrantedAuthority(loginAccount.getRole());
        grantList.add(authority);
        return 	new org.springframework.security.core.userdetails.User(String.valueOf(loginAccount.getLoginId()), loginAccount.getPassword(), grantList);
    
	}

	}

