package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.models.binding.RegisterUserBindingModel;

public interface UserService {

    void registerUser(RegisterUserBindingModel userBindingModel);

    boolean passwordMatch(RegisterUserBindingModel userBindingModel);

    boolean loginUser(RegisterUserBindingModel userBindingModel);
}
