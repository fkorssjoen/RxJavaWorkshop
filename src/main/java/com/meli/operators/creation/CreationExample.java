package com.meli.operators.creation;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class CreationExample {

  public static void main(String[] args) {
  }

  public static Observable<Integer> obsFromExample() {
    List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
    return Observable.from(numbersList);
  }

  public static Observable<List<Integer>> obsJustExample() {
    List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
    return Observable.just(numbersList);
  }

}
