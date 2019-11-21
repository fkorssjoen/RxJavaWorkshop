package com.meli.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.dto.CountryResponse;
import com.meli.dto.StateResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;

import java.io.IOException;

public class LocationsClient {
  public Observable<CountryResponse> getStatesByCountry(String countryId) {
    final OkHttpClient client = new OkHttpClient();
    return Observable.defer(() -> {
      String baseUrl = "http://api.internal.ml.com/classified_locations/countries/%s";
      String finalUrl = String.format(baseUrl, "CL");
      try {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = client.newCall(new Request.Builder().url(finalUrl).build()).execute();
        CountryResponse countryResponse = objectMapper.readValue(response.body().string(), CountryResponse.class);
        return Observable.just(countryResponse);
      } catch (IOException e) {
        return Observable.error(e);
      }
    });
  }

  public Observable<StateResponse> getCitiesByState(String stateId) {
    final OkHttpClient client = new OkHttpClient();
    return Observable.defer(() -> {
      String baseUrl = "http://api.internal.ml.com/classified_locations/states/%s";
      String finalUrl = String.format(baseUrl, stateId);
      try {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = client.newCall(new Request.Builder().url(finalUrl).build()).execute();
        StateResponse stateResponse = objectMapper.readValue(response.body().string(), StateResponse.class);
        return Observable.just(stateResponse);
      } catch (IOException e) {
        return Observable.error(e);
      }
    });
  }

}
