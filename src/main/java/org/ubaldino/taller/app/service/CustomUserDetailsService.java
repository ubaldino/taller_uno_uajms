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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.ubaldino.taller.app.dao.UserDao;
import org.ubaldino.taller.app.model.Role;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private UserDao userDao;
    /*
    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        
        User user = (User)userService.getUser(login);
        
        logger.info("loadUserByUsername username="+user.getLogin());
        
        if(!user.getLogin().equals("ubaldino")){
            throw new UsernameNotFoundException(user.getLogin()+ " not found");
        }

        //creating dummy user details, should do JDBC operations
        return new CustomUserDetails(user);
    }
    */
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findById(login);
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        if(user==null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        
        return new org.springframework.security.core.userdetails.User(
            login,user.getPassword(), true,
            true, true, true, getAuthorities(user)
        );

        
    }
    
    private List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach((Role role) -> {
            authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        });

        return authorities;
    }
    
}