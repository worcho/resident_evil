package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.models.binding.CapitalBindingModel;
import com.example.Resident.Evil.models.service.CapitalServiceModel;

import java.util.List;

public interface CapitalService {

    List<CapitalServiceModel> getAllCapitals();

    CapitalServiceModel getByName(String name);

    List<String> getAllCapitalsNames();

}
