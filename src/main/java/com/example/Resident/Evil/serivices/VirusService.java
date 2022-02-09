package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.models.binding.AddVirusBindingModel;
import com.example.Resident.Evil.models.service.VirusServiceModel;

import java.util.List;

public interface VirusService {

    void addVirus(VirusServiceModel model);

    void editVirus(Long virusId,VirusServiceModel model);

    void deleteVirus(Long virusId);

    VirusServiceModel getVirusById(Long id);

    List<String> findAllVirusCapitals(Long id);

    List<VirusServiceModel> getAllViruses();

    String getMap();
}
