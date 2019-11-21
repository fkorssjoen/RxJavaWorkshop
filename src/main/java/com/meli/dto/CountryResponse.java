package com.meli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryResponse {
  public List<StateResponse> getStates() {
    return states;
  }

  public void setStates(List<StateResponse> states) {
    this.states = states;
  }

  private List<StateResponse> states;
}
