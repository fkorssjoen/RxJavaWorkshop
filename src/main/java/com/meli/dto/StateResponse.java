package com.meli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StateResponse {
  private String id;
  private String name;
  private List<BaseLocationResponse> cities;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<BaseLocationResponse> getCities() {
    return cities;
  }

  public void setCities(List<BaseLocationResponse> cities) {
    this.cities = cities;
  }
}
