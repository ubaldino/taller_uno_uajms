package org.ubaldino.taller.app.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.ubaldino.taller.app.model.Profile;

/**
 *
 * @author ubaldino
 */

public class AuthUser extends User{
    private Profile profile;
    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities,Profile profile) {
        super(username,password,true,true, true, true,authorities);
        this.profile=profile;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object rhs) {
        return super.equals(rhs); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUsername() {
        return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return super.getAuthorities(); //To change body of generated methods, choose Tools | Templates.
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
}
