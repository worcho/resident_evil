package com.example.Resident.Evil.entities;

import com.example.Resident.Evil.entities.enums.VirusMagnitude;
import com.example.Resident.Evil.entities.enums.VirusMutation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Virus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "virusId", nullable = false, updatable = false)
    private Long virusId;

    @Column(nullable = false, unique = true)
    private String name;

    public Long getVirusId() {
        return virusId;
    }

    public void setVirusId(Long virusId) {
        this.virusId = virusId;
    }

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String sideEffects;

    @Column(nullable = false)
    private String creator;


    private String isDeadly;


    private String isCurable;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VirusMutation mutation;

    @Column(nullable = false)
    private Integer turnoverRate;

    @Column(nullable = false)
    private Integer hoursUntilTurn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VirusMagnitude magnitude;


    private String releaseOn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "viruses_capitals",
            joinColumns = @JoinColumn(
                    name = "virus_id",
                    referencedColumnName = "virusId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "capital_id",
                    referencedColumnName = "capitalId"
            )
    )
    @JsonIgnore
    private Set<Capital> capitals;


    public Set<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(Set<Capital> capitals) {
        this.capitals = capitals;
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
}
