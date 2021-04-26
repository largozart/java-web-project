package com.bivgroup.module.dadataclient.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @JsonProperty(value = "postal_code")
    public String postalCode;

    @JsonProperty(value = "country")
    public String country;

    @JsonProperty(value = "country_iso_code")
    public String countryIsoCode;

    @JsonProperty(value = "federal_district")
    public String federalDistrict;

    @JsonProperty(value = "region_fias_id")
    public String regionFiasId;

    @JsonProperty(value = "region_kladr_id")
    public String regionKladrId;

    @JsonProperty(value = "region_iso_code")
    public String regionIsoCode;

    @JsonProperty(value = "region_with_type")
    public String regionWithType;

    @JsonProperty(value = "region_type")
    public String regionType;

    @JsonProperty(value = "region_type_full")
    public String regionTypeFull;

    @JsonProperty(value = "region")
    public String region;

    @JsonProperty(value = "area_fias_id")
    public String areaFiasId;

    @JsonProperty(value = "area_kladr_id")
    public String areaKladrId;

    @JsonProperty(value = "area_with_type")
    public String areaWithType;

    @JsonProperty(value = "area_type")
    public String areaType;

    @JsonProperty(value = "area_type_full")
    public String areaTypeFull;

    @JsonProperty(value = "area")
    public String area;

    @JsonProperty(value = "city_fias_id")
    public String cityFiasId;

    @JsonProperty(value = "city_kladr_id")
    public String cityKladrId;

    @JsonProperty(value = "city_with_type")
    public String cityWithType;

    @JsonProperty(value = "city_area")
    public String cityArea;

    @JsonProperty(value = "city_district")
    public String cityDistrict;

    @JsonProperty(value = "city_type")
    public String cityType;

    @JsonProperty(value = "city_type_full")
    public String cityTypeFull;

    @JsonProperty(value = "city")
    public String city;
}
