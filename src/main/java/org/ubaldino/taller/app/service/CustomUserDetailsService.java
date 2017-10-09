package org.ubaldino.taller.app.service;

/**
 *
 * @author ubaldino
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.ubaldino.taller.app.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.UserDao;
import org.ubaldino.taller.app.model.Role;
import org.ubaldino.taller.app.security.AuthUser;

@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    @Autowired private UserDao userDao;
    
    @Override
    public AuthUser loadUserByUsername(final String login) throws UsernameNotFoundException {
        try {
            User user = userDao.findByLogin(login);
            if (user == null) {
                LOGGER.debug("user not found with the provided username");
                throw new UsernameNotFoundException("Invalid username or password");
            }
            LOGGER.debug(" user from username " + user.toString());
            
            return new AuthUser(
                login,user.getPassword(), getAuthorities(user),user.getProfile()
            );
        }
        catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("User not found");
        }
    }
    
    private List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach((Role role) -> {
            authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        });
        return authorities;
    }
    
}