package com.meli.operators.merge;

import rx.Observable;

public class MergeOperatorsExample {
  public static void main(String[] args) {

  }

  public static Observable<Integer> zipExample() {
    Integer[] a = {1, 2, 3, 4, 5};
    Integer[] b = {6, 7, 8, 9, 10};
    final Observable<Integer> obs1 = Observable.from(a);
    final Observable<Integer> obs2 = Observable.from(b);
    return Observable.zip(obs1, obs2, (firstObs, secondObs) -> firstObs + secondObs);
  }

  public static Observable<Integer> mergeExample() {
    Integer[] a = {1, 2, 3, 4, 5};
    Integer[] b = {6, 7, 8, 9, 10};
    final Observable<Integer> obs1 = Observable.from(a);
    final Observable<Integer> obs2 = Observable.from(b);
    return Observable.merge(obs1, obs2);
  }
}
