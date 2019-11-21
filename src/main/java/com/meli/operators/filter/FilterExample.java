package com.meli.operators.filter;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
  public static void main(String[] args) {

  }

  public static Observable<Integer> filterExample() {
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    return Observable.from(numbers)
        .map(integer -> integer * 2)
        .filter(integer -> integer > 4);
  }

  public static Observable<Integer> skipExample() {
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    return Observable.from(numbers)
        .skipWhile(integer -> integer < 4)
        .map(integer -> integer * 2);
  }

}
