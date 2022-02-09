package com.example.Resident.Evil.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Capital {

        @Id
        @Column(name = "capitalId", updatable = false, nullable = false)
        private Long capitalId;
        @Column(nullable = false, unique = true)
        private String name;
        @Column(nullable = false)
        private Double Latitude;
        @Column(nullable = false)
        private Double Longitude;
        @JsonIgnore
        @ManyToMany(mappedBy = "capitals", fetch = FetchType.LAZY)
        private Set<Virus> virusSet;

        public Long getCapitalId() {
                return capitalId;
        }

        public void setCapitalId(Long capitalId) {
                this.capitalId = capitalId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Double getLatitude() {
                return Latitude;
        }

        public void setLatitude(Double latitude) {
                Latitude = latitude;
        }

        public Double getLongitude() {
                return Longitude;
        }

        public void setLongitude(Double longitude) {
                Longitude = longitude;
        }

        public Set<Virus> getVirusSet() {
                return virusSet;
        }

        public void setVirusSet(Set<Virus> virusSet) {
                this.virusSet = virusSet;
        }
}
