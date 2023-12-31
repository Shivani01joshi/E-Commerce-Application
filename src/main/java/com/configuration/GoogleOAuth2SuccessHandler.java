package com.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List; // Import java.util.List
import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import java.util.ArrayList;
import com.model.Role;
import com.model.User;
@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler{

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,Authentication authentication)throws IOException
    {
        OAuth2AuthenticationToken token=(OAuth2AuthenticationToken) authentication;
        String email=token.getPrincipal().getAttributes().get("email").toString();
        if(userRepository.findUserByEmail(email).isPresent())
        {

        }
        else{
            User user=new User();
            user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setLastName(token.getPrincipal().getAttributes().get("Family_name").toString());
            user.setEmail(email);
            List<Role> roles=new ArrayList<>();
            roles.add(roleRepository.findById(2).get());
            user.setRoles(roles);
            userRepository.save(user);
        }
        redirectStrategy.sendRedirect(request,response,"/");
    }
} 