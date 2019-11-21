package com.meli.problems;

import com.meli.dto.ItemResponse;
import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkExamples {

  public static void main(String[] args) {
    List<String> itemIds = Arrays.asList("MLC514366774", "MLC514222201");
    getItemsTitle(itemIds);
  }

  public static Observable<List<String>> getItemsTitle(List<String> itemIds) {
    return Observable.just(itemIds);
  }

  public static Observable<List<String>> getChileLocations() {
    List<String> testLocations = Arrays.asList("Chile", "Las condes");
    return Observable.just(testLocations);
  }

  public static Observable<List<ItemResponse>> getNavigationItems(int userId) {
    List<ItemResponse> exampleList = new ArrayList<>();
    ItemResponse itemResponse = new ItemResponse();
    exampleList.add(itemResponse);
    return Observable.just(exampleList);
  }
}
