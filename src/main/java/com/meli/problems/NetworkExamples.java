package com.meli.problems;

import com.meli.clients.ItemClient;
import com.meli.clients.LocationsClient;
import com.meli.clients.NavigationClient;
import rx.Observable;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class NetworkExamples {

  private ItemClient itemClient;
  private NavigationClient navigationClient;
  private LocationsClient locationsClient;

  @Inject
  public NetworkExamples(ItemClient itemClient, NavigationClient navigationClient, LocationsClient locationsClient) {
    this.itemClient = itemClient;
    this.navigationClient = navigationClient;
    this.locationsClient = locationsClient;
  }

  public Observable<List<String>> getItemsTitle(List<String> itemIds) {
    return Observable.just(itemIds);
  }

  public static Observable<List<String>> getChileLocations() {
    List<String> testLocations = Arrays.asList("Chile", "Las condes");
    return Observable.just(testLocations);
  }

  public Observable<List<String>> getNavigationItems(int userId) {
    List<String> testLocations = Arrays.asList("Chile", "Las condes");
    return Observable.just(testLocations);
  }
}
