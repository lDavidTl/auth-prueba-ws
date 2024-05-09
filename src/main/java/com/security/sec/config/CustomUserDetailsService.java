package com.security.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


import com.security.sec.model.Usuario;
import com.security.sec.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario =  userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User Not Found with userName: " + userName));
		return usuario;
	}
	
	
	
	@Transactional
    public UserDetails loadUserById(Long id) {
        Usuario user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User" + id)
        );

        return user;
    }

}
