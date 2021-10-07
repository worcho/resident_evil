package com.example.Resident.Evil.serivices;

import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.models.binding.AddVirusBindingModel;
import com.example.Resident.Evil.repositories.CapitalRepository;
import com.example.Resident.Evil.repositories.VirusRepository;
import org.springframework.stereotype.Service;

@Service
public class VirusServiceImpl implements VirusService{

    private final CapitalRepository capitalRepository;
    private final VirusRepository virusRepository;

    public VirusServiceImpl(CapitalRepository capitalRepository, VirusRepository virusRepository) {
        this.capitalRepository = capitalRepository;
        this.virusRepository = virusRepository;
    }

    @Override
    public Virus getVirusFromForm(AddVirusBindingModel model) {

        Virus virus = new Virus();
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
        virus.setReleaseOn(model.getReleaseOn());
        if (virus.getIsDeadly() == null){
            virus.setIsDeadly("No");
        }
        if (virus.getIsCurable() == null){
            virus.setIsCurable("No");
        }

        return virus;
    }

    @Override
    public void saveMany(Long virusId, AddVirusBindingModel model) {
        for (int i = 0; i < model.getCapitals().length; i++) {
            Capital capital = capitalRepository.findByName(model.getCapitals()[i]);
            Long capitalId = capital.getCapitalId();
            virusRepository.saveManyToMany(virusId,capitalId);
        }
    }

    @Override
    public void editVirus(Long virusId, AddVirusBindingModel model) {
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
        //     virus.setReleaseOn(model.getReleaseOn());
        if (virus.getIsDeadly() == null){
            virus.setIsDeadly("No");
        }
        if (virus.getIsCurable() == null){
            virus.setIsCurable("No");
        }

        virusRepository.save(virus);

    }
}
