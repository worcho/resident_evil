package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.models.binding.AddVirusBindingModel;

public interface VirusService {

    Virus getVirusFromForm(AddVirusBindingModel model);

    void saveMany(Long virusId, AddVirusBindingModel model);

    void editVirus(Long virusId,AddVirusBindingModel model);
}
