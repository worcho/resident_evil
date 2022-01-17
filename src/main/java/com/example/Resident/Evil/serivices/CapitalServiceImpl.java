package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.models.service.CapitalServiceModel;
import com.example.Resident.Evil.repositories.CapitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapitalServiceImpl implements CapitalService{


    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository, ModelMapper modelMapper) {
        this.capitalRepository = capitalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CapitalServiceModel> getAllCapitals() {
        return capitalRepository.findAll()
                .stream()
                .map(x -> modelMapper.map(x,CapitalServiceModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public CapitalServiceModel getByName(String name) {
        return modelMapper.map(this.capitalRepository.findByName(name),CapitalServiceModel.class);
    }

    @Override
    public List<String> getAllCapitalsNames() {
        List<String> listNames = new ArrayList<>();
        List<Capital> capitalList = capitalRepository.findAll();
        for (int i = 0; i < capitalList.size(); i++) {
            listNames.add(capitalList.get(i).getName());
        }
        return listNames;
    }

    @Override
    public Page<Capital> getCapitals(Pageable pageable) {
  //      Pageable pageable = PageRequest.of(capitalPage.getPageNumber(),capitalPage.getPageSize());
        return this.capitalRepository.findAll(pageable);
    }


}
