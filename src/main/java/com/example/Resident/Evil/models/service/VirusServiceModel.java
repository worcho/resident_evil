package com.example.Resident.Evil.models.service;

import com.example.Resident.Evil.entities.enums.VirusMagnitude;
import com.example.Resident.Evil.entities.enums.VirusMutation;

import java.time.LocalDate;
import java.util.Set;

public class VirusServiceModel {

    private String virusId;

    private String name;

    private String description;

    private String sideEffects;

    private String creator;

    private String isDeadly;

    private String isCurable;

    private VirusMutation mutation;

    private Integer turnoverRate;

    private Integer hoursUntilTurn;

    private VirusMagnitude magnitude;

    private String releaseOn;

    private String[] capitals;

    public String getVirusId() {
        return virusId;
    }

    public void setVirusId(String virusId) {
        this.virusId = virusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getIsDeadly() {
        return isDeadly;
    }

    public void setIsDeadly(String isDeadly) {
        this.isDeadly = isDeadly;
    }

    public String getIsCurable() {
        return isCurable;
    }

    public void setIsCurable(String isCurable) {
        this.isCurable = isCurable;
    }

    public VirusMutation getMutation() {
        return mutation;
    }

    public void setMutation(VirusMutation mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public VirusMagnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(VirusMagnitude magnitude) {
        this.magnitude = magnitude;
    }

    public String getReleaseOn() {
        return releaseOn;
    }

    public void setReleaseOn(String releasedOn) {
        this.releaseOn = releasedOn;
    }

    public String[] getCapitals() {
        return capitals;
    }

    public void setCapitals(String[] capitals) {
        this.capitals = capitals;
    }
}
