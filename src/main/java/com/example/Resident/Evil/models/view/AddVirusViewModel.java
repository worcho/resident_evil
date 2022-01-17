package com.example.Resident.Evil.models.view;

import java.util.List;

public class AddVirusViewModel {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }

    private List<String> capitals;
}
