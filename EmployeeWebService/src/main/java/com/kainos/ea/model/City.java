package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

    public class City {

        private int ID;
        private String Name;
        private String CountryCode;
        private String District;
        private int Population;

        @JsonCreator
        public City(@JsonProperty("ID") int ID,@JsonProperty("Name") String name,
                    @JsonProperty("CountryCode") String countryCode,
                    @JsonProperty("District") String district,
                    @JsonProperty("Population") int population) {
            this.ID = ID;
            Name = name;
            CountryCode = countryCode;
            District = district;
            Population = population;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getCountryCode() {
            return CountryCode;
        }

        public void setCountryCode(String countryCode) {
            CountryCode = countryCode;
        }

        public String getDistrict() {
            return District;
        }

        public void setDistrict(String district) {
            District = district;
        }

        public int getPopulation() {
            return Population;
        }

        public void setPopulation(int population) {
            Population = population;
        }

    }

