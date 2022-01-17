package com.example.Resident.Evil.models.binding;


import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.entities.enums.VirusMagnitude;
import com.example.Resident.Evil.entities.enums.VirusMutation;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class AddVirusBindingModel {

    @NotEmpty(message = "Virus name cannot be empty.")
    @Size(min=3, max=10, message = "Virus name must be between 3 and 10 symbols long.")
    private String name;
    @NotEmpty(message = "Virus description cannot be empty.")
    @Size(min=5, max=100, message = "Virus description must be between 5 and 100 symbols long.")
    private String description;
    @Size(max=50, message = "Virus side effects must be up to 50 symbols long.")
    private String sideEffects;
    @Pattern(regexp = "^(Corp.|corp.)$", message = "Virus creator must either be 'Corp.' or 'corp.'")
    private String creator;
    private String isDeadly;
    private String isCurable;
    private VirusMutation mutation;
    @Min(value = 0, message = "Virus turnover rate must be greater than or equal to 0.")
    @Max(value = 100, message = "Virus turnover rate must be less than or equal to 100.")
    private Integer turnoverRate;
    @Min(value = 1, message = "Virus turnover rate must be greater than or equal to 1.")
    @Max(value = 12, message = "Virus turnover rate must be less than or equal to 12.")
    private Integer hoursUntilTurn;
    private VirusMagnitude magnitude;
    private String releaseOn;
    private String[] capitals;


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

    public void setReleaseOn(String releaseOn) {
        this.releaseOn = releaseOn;
    }

    public String[] getCapitals() {
        return capitals;
    }

    public void setCapitals(String[] capitals) {
        this.capitals = capitals;
    }


}
