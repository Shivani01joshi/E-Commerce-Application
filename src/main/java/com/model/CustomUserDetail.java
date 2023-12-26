package com.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail extends User implements UserDetails{
    private User user;

    public CustomUserDetail(User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the list of authorities (roles) for the user
        // Implement this based on your application's logic
        List<GrantedAuthority> authorityList=new ArrayList<>();
        super.getRoles().forEach(role->{
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        });
        return authorityList;
    }
    
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement your logic for account expiration
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement your logic for account locking
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement your logic for credentials expiration
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement your logic for user enablement
        return true;
    }
}
