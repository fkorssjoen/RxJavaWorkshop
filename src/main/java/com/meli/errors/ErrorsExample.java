package com.meli.errors;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class ErrorsExample {
  public static void main(String[] args) {
    exampleError2();
  }

  public static void exampleError() {
    List<String> numbersStrList = Arrays.asList("1", "2", "3", "hello world");
    Observable<Integer> integerObs = Observable.from(numbersStrList).
        map(number -> {
          try {
            return Integer.parseInt(number);
          } catch (NumberFormatException e) {
            System.out.println("an error has happended " + e.getMessage());
            return 4;
          }
        });
    integerObs.subscribe((x -> System.out.println(x)), (error -> System.out.println(error)));
  }

  public static void exampleError1() {
    List<String> numbersStrList = Arrays.asList("1", "2", "3", "hello world");
    final Observable<Integer> integerObs = Observable.from(numbersStrList).
        map(number -> Integer.parseInt(number))
        .doOnError(throwable -> System.out.println("an error has happended " + throwable.getMessage()))
        .onErrorReturn(throwable -> 4);
    integerObs.subscribe((x -> System.out.println(x)), (error -> System.out.println(error)));
  }

  public static void exampleError2() {
    List<String> numbersStrList = Arrays.asList("1", "2", "3", "hello world");
    final Observable<Integer> integerObs = Observable.from(numbersStrList).
        map(number -> Integer.parseInt(number))
        .doOnError(throwable -> System.out.println("an error has happended " + throwable.getMessage()))
        .onErrorResumeNext(Observable.just(1));

    integerObs.subscribe((x -> System.out.println(x)), (error -> System.out.println(error)));
  }

  public static void exampleErrorRetry() {
    List<String> numbersStrList = Arrays.asList("1", "2", "3", "hello world");
    final Observable<Integer> integerObs = Observable.from(numbersStrList).
        map(number -> Integer.parseInt(number))
        .doOnError(throwable -> System.out.println("an error has happended " + throwable.getMessage()))
        .retry(1);
    integerObs.subscribe((x -> System.out.println(x)), (error -> System.out.println(error)));
  }

  public static void exampleErrorRetry2() {
    List<String> numbersStrList = Arrays.asList("1", "2", "3", "hello world");
    final Observable<Integer> integerObs = Observable.from(numbersStrList).
        map(number -> Integer.parseInt(number))
        .doOnError(throwable -> System.out.println("an error has happended " + throwable.getMessage()))
        .retry(((integer, throwable) -> integer < 3));
    integerObs.subscribe((x -> System.out.println(x)), (error -> System.out.println(error)));
  }
}
