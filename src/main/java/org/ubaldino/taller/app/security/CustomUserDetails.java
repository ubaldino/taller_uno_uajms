
package org.ubaldino.taller.app.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.ubaldino.taller.app.model.Role;
import org.ubaldino.taller.app.model.User;

/**
 *
 * @author ubaldino
 */
public class CustomUserDetails implements UserDetails{
    
    private static final long serialVersionUID = 74446635341925780L;
    private final User user;    

    public User getUser() {
        return user;
    }
    
    public CustomUserDetails(User user){
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.user.getRoles().stream().map((Role role) -> {
            return role;
        }).forEachOrdered((Role role) -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getNombre()));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
