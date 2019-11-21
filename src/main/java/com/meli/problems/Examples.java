package com.meli.problems;

import com.meli.clients.LocationsClient;
import rx.Observable;

import java.util.List;

public class Examples {

  public static void main(String[] args) {
//    NavigationClient navigationClient = new NavigationClient();
//    ItemClient itemClient = new ItemClient();

    LocationsClient locationsClient = new LocationsClient();

    final Observable<List<String>> locationsObs = locationsClient.getStatesByCountry("CL")
        .map(countryResponse -> countryResponse.getStates())
        .flatMap(Observable::from)
        .flatMap(stateResponse -> locationsClient.getCitiesByState(stateResponse.getId()))
        .map(stateResponse -> stateResponse.getCities())
        .flatMap(Observable::from)
        .map(baseLocationResponse -> baseLocationResponse.getName())
        .toList();

    locationsObs.subscribe(System.out::println);


//    final Observable<List<String>> navigationObs = navigationClient
//        .getNavigationByUser(406763783)
//        .flatMap(Observable::from)
//        .map(NavigationResponse::getItemId)
//        .flatMap(itemid -> itemClient.getItem(itemid))
//        .map(itemResponse -> itemResponse.getTitle())
//        .toList();
//
//    navigationObs.subscribe(System.out::println);
  }


}
