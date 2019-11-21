package com.meli.problems;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class TransformationProblems {
  public static Observable<List<String>> getStringList(List<Integer> numberList) {
    List<String> numbersListStr = Arrays.asList("1", "2", "3", "4", "5", "6");
    return Observable.just(numbersListStr);
  }

  public static Observable<List<Integer>> getListsSum(List<Integer> firstList, List<Integer> secondList) {
    List<Integer> numbersList = Arrays.asList(1, 2, 3);
    return Observable.just(numbersList);
  }
}
