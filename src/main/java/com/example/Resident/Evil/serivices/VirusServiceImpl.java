package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.entities.enums.VirusMagnitude;
import com.example.Resident.Evil.models.binding.AddVirusBindingModel;
import com.example.Resident.Evil.models.service.VirusServiceModel;
import com.example.Resident.Evil.repositories.CapitalRepository;
import com.example.Resident.Evil.repositories.VirusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VirusServiceImpl implements VirusService{

    private final CapitalRepository capitalRepository;
    private final VirusRepository virusRepository;
    private final ModelMapper modelMapper;

    public VirusServiceImpl(CapitalRepository capitalRepository, VirusRepository virusRepository, ModelMapper modelMapper) {
        this.capitalRepository = capitalRepository;
        this.virusRepository = virusRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VirusServiceModel getVirusById(Long id) {
        return modelMapper.map(virusRepository.getById(id),VirusServiceModel.class);
    }

    @Override
    public List<String> findAllVirusCapitals(Long id) {
        return virusRepository.findAllVirusCapitals(id);
    }

    @Override
    public List<VirusServiceModel> getAllViruses() {
        return virusRepository.findAll()
                .stream()
                .map(v -> modelMapper.map(v,VirusServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addVirus(VirusServiceModel model) {
        Virus virus = modelMapper.map(model,Virus.class);
        if (virus.getIsDeadly() == null){
            virus.setIsDeadly("No");
        }
        if (virus.getIsCurable() == null){
            virus.setIsCurable("No");
        }
        virus.setCapitals(Arrays.stream(model.getCapitals())
                .map(x -> capitalRepository.findByName(x))
                .collect(Collectors.toSet()));
        virusRepository.save(virus);
    }

    @Override
    public void editVirus(Long virusId, VirusServiceModel model) {
        Virus virus = virusRepository.getById(virusId);
        virus.setName(model.getName());
        virus.setDescription(model.getDescription());
        virus.setSideEffects(model.getSideEffects());
        virus.setCreator(model.getCreator());
        virus.setIsDeadly(model.getIsDeadly());
        virus.setIsCurable(model.getIsCurable());
        virus.setMutation(model.getMutation());
        virus.setTurnoverRate(model.getTurnoverRate());
        virus.setHoursUntilTurn(model.getHoursUntilTurn());
        virus.setMagnitude(model.getMagnitude());
        if (virus.getIsDeadly() == null){
            virus.setIsDeadly("No");
        }
        if (virus.getIsCurable() == null){
            virus.setIsCurable("No");
        }
        virusRepository.save(virus);

    }

    @Override
    public void deleteVirus(Long virusId) {
        virusRepository.deleteById(virusId);
    }

    @Override
    public String getMap() {
        StringBuilder result = new StringBuilder();

        result
                .append("{")
                .append("   \"type\": \"FeatureCollection\",")
                .append("   \"features\": [");

        for (Virus currentVirus : this.virusRepository.findAll()) {
            for (Capital currentCapital : currentVirus.getCapitals()) {
                result
                        .append("{")
                        .append("\"type\": \"Feature\",")
                        .append("\"properties\": {")
                        .append("\"mag\": " + VirusMagnitude
                                .getNumeralValue(currentVirus.getMagnitude()) + ",")
                        .append("\"color\": \"#F00\"")
                        .append("},")
                        .append("\"geometry\": {")
                        .append("\"type\": \"Point\",")
                        .append("\"coordinates\": [")
                        .append(currentCapital.getLatitude())
                        .append(",")
                        .append(currentCapital.getLongitude())
                        .append("]")
                        .append("}")
                        .append("},");
            }
        }

        result.replace(result.length() - 1, result.length(), "");

        result
                .append("]")
                .append("}");

        return result.toString();
    }
}
