package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.entities.User;
import com.example.Resident.Evil.models.binding.RegisterUserBindingModel;
import com.example.Resident.Evil.models.service.UserServiceModel;
import com.example.Resident.Evil.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegisterUserBindingModel userBindingModel) {
        User user = new User();
        modelMapper.map(userBindingModel, user);
        user.setPassword(passwordEncoder.encode(userBindingModel.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public void editUser(Long userId, UserServiceModel userServiceModel) {
        User user = userRepository.getById(userId);
        user.setRole(userServiceModel.getRole());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean passwordMatch(RegisterUserBindingModel userBindingModel) {
        if (userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean loginUser(RegisterUserBindingModel userBindingModel) {
        User username = userRepository.findByUsername(userBindingModel.getUsername());
        if (username != null) {
            if (username.getPassword().equals(userBindingModel.getPassword())) {
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }

        Set<GrantedAuthority> role = new HashSet<>();
        if (user.getRole().equals("ADMIN")) {
            role.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else if (user.getRole().equals("MODERATOR")){
            role.add(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }else {
            role.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                role
        );
        return userDetails;

    }
}
