package com.example.Resident.Evil.models.service;

public class CapitalServiceModel {

    private Long capitalId;
    private String name;
    private Double longitude;
    private Double latitude;

    public Long getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(Long capitalId) {
        this.capitalId = capitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String namee) {
        this.name = namee;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
