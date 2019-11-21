package com.meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NavigationResponse {
  @JsonProperty("item_id")
  private String itemId;
  private String visited;

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getVisited() {
    return visited;
  }

  public void setVisited(String visited) {
    this.visited = visited;
  }
}
