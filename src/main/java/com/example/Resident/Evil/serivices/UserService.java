package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.models.binding.RegisterUserBindingModel;
import com.example.Resident.Evil.models.service.UserServiceModel;

public interface UserService {

    void registerUser(RegisterUserBindingModel userBindingModel);

    void editUser(Long id, UserServiceModel userServiceModel);

    void deleteUser(Long id);

    boolean passwordMatch(RegisterUserBindingModel userBindingModel);

    boolean loginUser(RegisterUserBindingModel userBindingModel);
}
