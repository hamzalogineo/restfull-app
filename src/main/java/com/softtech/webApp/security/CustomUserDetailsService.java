package com.softtech.webApp.security;

// import com.example.polls.exception.ResourceNotFoundException;
// import com.example.polls.model.User;
// import com.example.polls.repository.UserRepository;



import com.softtech.webApp.dao.ClientRepository;
import com.softtech.webApp.entities.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    ClientRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) {
        // Let people login with either username or email
        Clients user = userRepository.findByLogin(usernameOrEmail) ;

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Clients user = userRepository.getOne(id) ;

        return UserPrincipal.create(user);
    }
}