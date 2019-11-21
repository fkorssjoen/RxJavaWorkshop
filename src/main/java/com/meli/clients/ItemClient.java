package com.meli.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.dto.ItemResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;

import java.io.IOException;

public class ItemClient {
  public Observable<ItemResponse> getItem(String meliId) {
    final OkHttpClient client = new OkHttpClient();
    return Observable.defer(() -> {
      String baseUrl = "http://api.internal.ml.com/items/%s";
      final String finalUrl = String.format(baseUrl, meliId);
      try {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = client.newCall(new Request.Builder().url(finalUrl).build()).execute();
        ItemResponse itemResponse = objectMapper.readValue(response.body().string(), ItemResponse.class);
        return Observable.just(itemResponse);
      } catch (IOException e) {
        return Observable.error(e);
      }
    });
  }
}
