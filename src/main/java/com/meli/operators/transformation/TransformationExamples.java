package com.meli.operators.transformation;

import com.meli.dto.ItemResponse;
import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TransformationExamples {
  public static void main(String[] args) {
    toListExample();
  }

  public static Observable<Integer> mapExample() {
    Integer[] exampleArray = {1, 2, 3, 4, 5};
    Observable<Integer> obs1 = Observable.from(exampleArray);
    Observable<Integer> mapObs = obs1.map(x -> x * 2);
    return mapObs;
  }

  public static Observable<String> flatMapExample() {
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    return Observable.from(numbers)
        .flatMap(integer -> Observable.just(integer.toString()))
        .map(string -> "number :" + string);
  }

  public static Observable<String> concatMapExample() {
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    return Observable.from(numbers)
        .concatMap(integer -> Observable.just(integer.toString()))
        .map(string -> "number :" + string);
  }

  public static void flatMapAndConcatMapExample() {
    final List<Integer> race = Arrays.asList(1, 2, 3, 4, 5, 6);

    Observable.from(race)
        .flatMap(integer -> {
          final int delay = new Random().nextInt(5);
          return Observable.just(integer)
              .delay(delay, TimeUnit.MILLISECONDS);
        }).subscribe(x -> System.out.println("FLATMAP: " + x));

    Observable.from(race)
        .concatMap(integer -> {
          final int delay = new Random().nextInt(5);
          return Observable.just(integer)
              .delay(delay, TimeUnit.MILLISECONDS);
        }).subscribe(x -> System.out.println("CONCATMAP: " + x));
  }

  public static Observable<Integer> reduceExample1() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
    return Observable.from(numbers)
        .reduce((x, y) -> x + y);
  }


  public static Observable<List<Integer>> reduceExample2() {
    List<String> oldList = Arrays.asList("1", "2", "3", "4");
    List<Integer> newList = new ArrayList<>();
    return Observable.from(oldList)
        .reduce(newList, (list, x) -> {
          list.add(Integer.parseInt(x));
          return list;
        });
  }


  public static Observable<List<String>> toListExample() {
    ItemResponse firstItemResponse = new ItemResponse();
    firstItemResponse.setId("MLC123");
    firstItemResponse.setTitle("first title");

    ItemResponse secondItemResponse = new ItemResponse();
    secondItemResponse.setId("MLC456");
    secondItemResponse.setTitle("second title");

    List<ItemResponse> itemResponseList = Arrays.asList(firstItemResponse, secondItemResponse);
    return Observable.from(itemResponseList)
        .map(ItemResponse::getTitle)
        .toList();
  }


}
