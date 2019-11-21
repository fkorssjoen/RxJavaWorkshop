package com.meli.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.dto.NavigationResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class NavigationClient {
  public Observable<List<NavigationResponse>> getNavigationByUser(Integer userId) {
    final OkHttpClient client = new OkHttpClient();
    return Observable.defer(() -> {
      String baseUrl = "http://api.internal.ml.com/users/%d/navigation/items/last?platform_id=PI&site_id=MLC&caller.id=%d";
      String finalUrl = String.format(baseUrl, userId, userId);
      try {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = client.newCall(new Request.Builder().url(finalUrl).build()).execute();
        final NavigationResponse[] navigationResponses = objectMapper.readValue(response.body().string(), NavigationResponse[].class);
        return Observable.just(Arrays.asList(navigationResponses));
      } catch (IOException e) {
        return Observable.error(e);
      }
    });
  }
}
