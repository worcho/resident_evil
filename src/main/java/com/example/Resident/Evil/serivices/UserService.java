package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.models.binding.RegisterUserBindingModel;
import com.example.Resident.Evil.models.service.UserServiceModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    void editUser(Long id, UserServiceModel userServiceModel);

    void deleteUser(Long id);

    UserServiceModel searchedByUsername(String username);

    List<UserServiceModel> getAllUsers();

    boolean passwordMatch(RegisterUserBindingModel userBindingModel);

}
