package org.ubaldino.taller.app.service;

/**
 *
 * @author ubaldino
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.ubaldino.taller.app.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.ubaldino.taller.app.dao.UserDao;
import org.ubaldino.taller.app.model.Role;

@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    @Autowired private UserDao userDao;
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
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        /*User user = userDao.findById(login);
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        if(user==null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        
        return new org.springframework.security.core.userdetails.User(
            login,user.getPassword(), true,
            true, true, true, getAuthorities(user)
        );
        */
        LOGGER.debug("-----------------");
        LOGGER.debug("::CustomUserDetailsService:: login="+login);
        LOGGER.debug("-----------------");
        
        try {
            User user = userDao.findById(login);
            if (user == null) {
                LOGGER.debug("user not found with the provided username");
                throw new UsernameNotFoundException("Invalid username or password");
            }
            LOGGER.debug(" user from username " + user.toString());
            
            return new org.springframework.security.core.userdetails.User(
                login,user.getPassword(), true,
                true, true, true, getAuthorities(user)
            );
        }
        catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("User not found");
        }

        
    }
    
    /*
    private Set<GrantedAuthority> getAuthorities(User user){
        Set<GrantedAuthority> authorities = new HashSet<>();
        user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getNombre())).forEachOrdered((grantedAuthority) -> {
            authorities.add(grantedAuthority);
        });
        LOGGER.debug("user authorities are " + authorities.toString());
        return authorities;
    }
    */
    
    private List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach((Role role) -> {
            authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        });
        return authorities;
    }
    
    
}