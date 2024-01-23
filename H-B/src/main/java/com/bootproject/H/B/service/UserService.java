package com.bootproject.H.B.service;


import com.bootproject.H.B.model.User;
import com.bootproject.H.B.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private IUserRepository userRepo;

    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }


//    public boolean isEmailUnique(String email) {
//        User userEmail = userRepo.findByEmail(email);
//        return userEmail == null;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(
                                role -> role
                                        .getName())
                        .toArray(String[]::new))
                .build();
    }




}
